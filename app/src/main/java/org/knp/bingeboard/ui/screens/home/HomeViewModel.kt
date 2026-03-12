package org.knp.bingeboard.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.mapper.toShowDetails
import org.knp.bingeboard.data.mapper.toWatchlistDisplayItem
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import org.knp.bingeboard.data.repository.TvdbRepository
import org.knp.bingeboard.data.repository.TvMazeRepository
import org.knp.bingeboard.data.repository.UserPreferencesRepository
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
    private val tvMazeRepository: TvMazeRepository,
    private val tvdbRepository: TvdbRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            // Subscribe to the watchlist flow
            watchlistRepository.watchlist.collect { entries ->
                val filtered = entries.filter { it.source == "tvmaze" || it.source == "tvdb" }
                val sorted = filtered.sortedWith(compareBy(nullsLast()) { it.sortDate })
                _uiState.value = _uiState.value.copy(
                    watchlistItems = sorted,
                    isLoading = false
                )

                // If we have legacy items that haven't been populated
                if (filtered.any { it.name == "Loading..." }) {
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
     * Always uses the CURRENT user preference (TVDB toggle) to decide which API to call.
     */
    fun refreshWatchlist() {
        viewModelScope.launch { syncWatchlist() }
    }

    suspend fun syncWatchlist() {
        _uiState.value = _uiState.value.copy(isRefreshing = true, error = null)

        val useTvdb = userPreferencesRepository.useTvdb.first()
        val entries = watchlistRepository.watchlist.first()
        val updatedItems = mutableListOf<WatchlistDisplayItem>()

        for (entry in entries) {
            try {
                if (entry.mediaType == "tv") {
                    // Always use the CURRENT user preference, not the stored source
                    val displayItem = if (useTvdb) {
                        refreshFromTvdb(entry)
                    } else {
                        refreshFromTvMaze(entry)
                    }
                    updatedItems.add(displayItem)
                }
            } catch (_: Exception) {
                updatedItems.add(entry) // Keep the old one if fetching fails
            }
        }

        watchlistRepository.updateWatchlist(updatedItems)
        _uiState.value = _uiState.value.copy(isRefreshing = false)
    }

    private suspend fun refreshFromTvMaze(entry: WatchlistDisplayItem): WatchlistDisplayItem {
        val mazeId = entry.tvmazeId ?: entry.mediaId
        val result = tvMazeRepository.getShowDetailsWithEpisodes(mazeId)
        val show = result.getOrNull() ?: return entry
        val airTimeInfo = tvMazeRepository.getAirTimeInfo(show)
        val showDetails = show.toShowDetails(
            airSchedule = airTimeInfo?.displayLabel,
            airTimestamp = airTimeInfo?.userDateTime?.toInstant()?.toEpochMilli()
        )
        return showDetails.toWatchlistDisplayItem()
    }

    private suspend fun refreshFromTvdb(entry: WatchlistDisplayItem): WatchlistDisplayItem {
        // Use stored tvdbId (from TVmaze cross-reference), fall back to mediaId
        val tvdbId = entry.tvdbId ?: return entry  // no TVDB ID known, skip
        val seriesResult = tvdbRepository.getSeries(tvdbId)
        val episodesResult = tvdbRepository.getSeriesEpisodes(tvdbId)
        val series = seriesResult.getOrNull()?.data ?: return entry
        val episodes = episodesResult.getOrNull()?.data?.episodes
        val nextEp = tvdbRepository.findLatestOrNextEpisode(episodes)
        val showDetails = series.toShowDetails(
            nextEpisode = nextEp,
            airTimestamp = tvdbRepository.parseAirDate(nextEp?.aired, series.airsTime, series.originalCountry),
            tvmazeId = entry.tvmazeId  // preserve TVmaze ID
        )
        return showDetails.toWatchlistDisplayItem()
    }

    fun retry() = refreshWatchlist()
}
