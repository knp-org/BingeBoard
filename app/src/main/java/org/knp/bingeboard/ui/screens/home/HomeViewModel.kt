package org.knp.bingeboard.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.time.LocalDate
import org.knp.bingeboard.data.model.TvMazeShow
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import org.knp.bingeboard.data.repository.TvMazeRepository
import org.knp.bingeboard.data.repository.WatchlistRepository
import javax.inject.Inject

data class HomeUiState(
    val watchlistItems: List<WatchlistDisplayItem> = emptyList(),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val watchlistRepository: WatchlistRepository,
    private val tvMazeRepository: TvMazeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            // Subscribe to the watchlist flow
            watchlistRepository.watchlist.collect { entries ->
                val filtered = entries.filter { it.source == "tvmaze" }
                val sorted = filtered.sortedWith(compareBy(nullsLast()) { it.sortDate })
                _uiState.value = _uiState.value.copy(
                    watchlistItems = sorted,
                    isLoading = false
                )

                // If we have legacy items that haven't been populated
                if (filtered.any { it.name == "Loading..." || (it.airTimeDisplay != null && it.airTimestamp == null) }) {
                    refreshWatchlist()
                }
            }
        }
    }

    /**
     * Used for initial load triggers if needed by UI
     */
    fun loadWatchlist() {
        // Data is collected automatically via Flow, so this is mostly a no-op now,
        // but we keep the signature for compatibility with the View.
    }

    /**
     * Refresh the watchlist by making API calls for all items.
     * This is used for pull-to-refresh and for migrating legacy items.
     */
    fun refreshWatchlist() {
        viewModelScope.launch { syncWatchlist() }
    }

    suspend fun syncWatchlist() {
        _uiState.value = _uiState.value.copy(isRefreshing = true, error = null)

        val entries = watchlistRepository.watchlist.first()
        val updatedItems = mutableListOf<WatchlistDisplayItem>()

        for (entry in entries) {
            try {
                if (entry.mediaType == "tv" && entry.source == "tvmaze") {
                    val result = tvMazeRepository.getShowDetailsWithEpisodes(entry.mediaId)
                    result.getOrNull()?.let { show ->
                        val airTimeInfo = tvMazeRepository.getAirTimeInfo(show)
                        updatedItems.add(show.toDisplayItem(
                            airTimeDisplay = airTimeInfo?.displayLabel,
                            airTimestamp = airTimeInfo?.userDateTime?.toInstant()?.toEpochMilli()
                        ))
                    } ?: run { updatedItems.add(entry) }
                }
                // Skip TMDB and movie entries - they are no longer supported
            } catch (_: Exception) {
                if (entry.source == "tvmaze") {
                    updatedItems.add(entry) // Keep the old one if fetching fails
                }
            }
        }

        watchlistRepository.updateWatchlist(updatedItems)
        _uiState.value = _uiState.value.copy(isRefreshing = false)
    }

    fun retry() = refreshWatchlist()

    private fun TvMazeShow.toDisplayItem(
        airTimeDisplay: String? = null,
        airTimestamp: Long? = null
    ): WatchlistDisplayItem {
        val today = LocalDate.now().toString() // "yyyy-MM-dd"

        // Priority logic: If previous episode airs today, treat it as latest (API may show next as ep 7 when ep 6 airs today).
        val prevEp = embedded?.previousepisode
        val nextEp = embedded?.nextepisode
        val isPrevToday = prevEp?.airdate == today
        val displayEp = if (isPrevToday) prevEp else nextEp
        val displayDate = displayEp?.airdate ?: schedule?.time?.takeIf { it.isNotBlank() }
        val displayTimestamp = tvMazeRepository.parseAirstamp(displayEp?.airstamp) ?: airTimestamp

        return WatchlistDisplayItem(
            mediaType = "tv",
            mediaId = id,
            source = "tvmaze",
            name = name,
            posterUrl = image?.medium,
            backdropPath = null,
            voteAverage = rating?.average ?: 0.0,
            status = status,
            sortDate = displayDate,
            nextEpisodeLabel = displayEp?.let { ep ->
                "S${ep.season}E${ep.number}" + (" — ${ep.name}")
            },
            genres = genres.joinToString(", "),
            airTimeDisplay = airTimeDisplay,
            airTimestamp = displayTimestamp
        )
    }
}
