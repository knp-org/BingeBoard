package org.knp.bingeboard.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.repository.TvdbRepository
import org.knp.bingeboard.data.repository.TvMazeRepository
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import javax.inject.Inject

/**
 * Search result from TVmaze (TV shows only).
 */
data class SearchDisplayItem(
    val id: Int,
    val mediaType: String,        // "tv"
    val source: String,           // "tvmaze"
    val displayName: String,
    val overview: String?,
    val posterUrl: String?,        // full URL from TVmaze
    val voteAverage: Double,
    val year: String?,
    val score: Double = 0.0       // search relevance score
)

data class SearchUiState(
    val query: String = "",
    val results: List<SearchDisplayItem> = emptyList(),
    val isLoading: Boolean = false,
    val hasSearched: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val tvMazeRepository: TvMazeRepository,
    private val tvdbRepository: TvdbRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    private var searchJob: Job? = null

    fun onQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(query = query)

        searchJob?.cancel()
        if (query.isBlank()) {
            _uiState.value = _uiState.value.copy(
                results = emptyList(),
                hasSearched = false,
                error = null
            )
            return
        }

        searchJob = viewModelScope.launch {
            delay(400) // debounce 400ms
            performSearch(query)
        }
    }

    fun searchNow() {
        val query = _uiState.value.query
        if (query.isNotBlank()) {
            searchJob?.cancel()
            viewModelScope.launch { performSearch(query) }
        }
    }

    private suspend fun performSearch(query: String) {
        _uiState.value = _uiState.value.copy(isLoading = true, error = null)

        val useTvdb = userPreferencesRepository.useTvdb.first()
        val combined = mutableListOf<SearchDisplayItem>()

        if (useTvdb) {
            val tvdbDeferred = viewModelScope.async {
                tvdbRepository.searchSeries(query)
            }
            tvdbDeferred.await().getOrNull()?.data?.forEach { result ->
                combined.add(
                    SearchDisplayItem(
                        id = result.tvdb_id?.removePrefix("series-")?.toIntOrNull() ?: 0,
                        mediaType = "tv",
                        source = "tvdb",
                        displayName = result.name ?: "Unknown",
                        overview = result.overview,
                        posterUrl = result.image_url,
                        voteAverage = 0.0, // TVDB search doesn't return score easily in v4
                        year = result.year,
                        score = 0.0
                    )
                )
            }
        } else {
            // Search TVmaze (TV shows)
            val tvMazeDeferred = viewModelScope.async {
                tvMazeRepository.searchShows(query)
            }

            // TVmaze results → TV shows
            tvMazeDeferred.await().getOrNull()?.forEach { result ->
                val show = result.show
                combined.add(
                    SearchDisplayItem(
                        id = show.id,
                        mediaType = "tv",
                        source = "tvmaze",
                        displayName = show.name,
                        overview = tvMazeRepository.cleanSummary(show.summary),
                        posterUrl = show.image?.medium,
                        voteAverage = show.rating?.average ?: 0.0,
                        year = show.premiered?.take(4),
                        score = result.score
                    )
                )
            }
        }

        // Sort: TV shows first (higher relevance from TVmaze)
        val sorted = if (useTvdb) combined else combined.sortedByDescending { it.score }

        _uiState.value = _uiState.value.copy(
            results = sorted,
            isLoading = false,
            hasSearched = true,
            error = null
        )
    }
}
