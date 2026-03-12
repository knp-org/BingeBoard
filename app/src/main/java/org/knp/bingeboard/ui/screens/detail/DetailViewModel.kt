package org.knp.bingeboard.ui.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.mapper.toShowDetails
import org.knp.bingeboard.data.mapper.toWatchlistDisplayItem
import org.knp.bingeboard.data.model.ShowDetails
import org.knp.bingeboard.data.repository.TvdbRepository
import org.knp.bingeboard.data.repository.TvMazeRepository
import org.knp.bingeboard.data.repository.WatchlistRepository
import javax.inject.Inject

data class DetailUiState(
    val show: ShowDetails? = null,
    val isLoading: Boolean = true,
    val error: String? = null,
    val isInWatchlist: Boolean = false
)

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val tvMazeRepository: TvMazeRepository,
    private val tvdbRepository: TvdbRepository,
    private val watchlistRepository: WatchlistRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private val mediaId: Int = savedStateHandle.get<Int>("mediaId") ?: 0
    private val mediaType: String = savedStateHandle.get<String>("mediaType") ?: "tv"
    private val source: String = savedStateHandle.get<String>("source") ?: "tvmaze"

    init {
        loadDetails()
    }

    private fun loadDetails() {
        viewModelScope.launch {
            _uiState.value = DetailUiState(isLoading = true)
            val inWatchlist = watchlistRepository.isInWatchlist(mediaType, mediaId)

            if (mediaType == "tv") {
                val showDetails = when (source) {
                    "tvdb" -> loadFromTvdb()
                    else -> loadFromTvMaze()
                }

                _uiState.value = DetailUiState(
                    show = showDetails,
                    isLoading = false,
                    error = if (showDetails == null) "Failed to load details" else null,
                    isInWatchlist = inWatchlist
                )
            } else {
                _uiState.value = DetailUiState(
                    isLoading = false,
                    error = "Unsupported media type"
                )
            }
        }
    }

    private suspend fun loadFromTvMaze(): ShowDetails? {
        val result = tvMazeRepository.getShowDetails(mediaId)
        val mazeShow = result.getOrNull() ?: return null
        val airTimeInfo = tvMazeRepository.getAirTimeInfo(mazeShow)
        return mazeShow.toShowDetails(
            airSchedule = airTimeInfo?.displayLabel,
            airTimestamp = airTimeInfo?.userDateTime?.toInstant()?.toEpochMilli()
        )
    }

    private suspend fun loadFromTvdb(): ShowDetails? {
        val seriesResult = tvdbRepository.getSeries(mediaId)
        val episodesResult = tvdbRepository.getSeriesEpisodes(mediaId)

        val series = seriesResult.getOrNull()?.data ?: return null
        val episodes = episodesResult.getOrNull()?.data?.episodes
        val nextEp = tvdbRepository.findLatestOrNextEpisode(episodes)

        return series.toShowDetails(
            nextEpisode = nextEp,
            airTimestamp = tvdbRepository.parseAirDate(nextEp?.aired, series.airsTime, series.originalCountry)
        )
    }

    fun toggleWatchlist() {
        viewModelScope.launch {
            val currentlyInList = _uiState.value.isInWatchlist
            if (currentlyInList) {
                watchlistRepository.removeFromWatchlist(mediaType, mediaId)
            } else {
                _uiState.value.show?.let { show ->
                    watchlistRepository.addToWatchlist(show.toWatchlistDisplayItem())
                }
            }
            _uiState.value = _uiState.value.copy(isInWatchlist = !currentlyInList)
        }
    }

    fun retry() {
        loadDetails()
    }
}
