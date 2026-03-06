package org.knp.bingeboard.ui.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import org.knp.bingeboard.data.model.TvMazeShow
import org.knp.bingeboard.data.repository.TvMazeRepository
import org.knp.bingeboard.data.repository.WatchlistRepository
import javax.inject.Inject

data class DetailUiState(
    val tvMazeShow: TvMazeShow? = null,
    val isLoading: Boolean = true,
    val error: String? = null,
    val isInWatchlist: Boolean = false,
    val airTimeDisplay: String? = null,
    val source: String = "tvmaze"
)

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val tvMazeRepository: TvMazeRepository,
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
            _uiState.value = DetailUiState(isLoading = true, source = source)
            val inWatchlist = watchlistRepository.isInWatchlist(mediaType, mediaId)

            if (mediaType == "tv" && source == "tvmaze") {
                val result = tvMazeRepository.getShowDetails(mediaId)
                val mazeShow = result.getOrNull()
                val airTimeDisplay = mazeShow?.let { tvMazeRepository.getAirTimeInfo(it)?.displayLabel }

                _uiState.value = DetailUiState(
                    tvMazeShow = mazeShow,
                    isLoading = false,
                    error = result.exceptionOrNull()?.message,
                    isInWatchlist = inWatchlist,
                    airTimeDisplay = airTimeDisplay,
                    source = source
                )
            } else {
                _uiState.value = DetailUiState(
                    isLoading = false,
                    error = "Unsupported media type or source",
                    source = source
                )
            }
        }
    }

    fun toggleWatchlist() {
        viewModelScope.launch {
            val currentlyInList = _uiState.value.isInWatchlist
            if (currentlyInList) {
                watchlistRepository.removeFromWatchlist(mediaType, mediaId)
            } else {
                val state = _uiState.value
                state.tvMazeShow?.let { show ->
                    val today = LocalDate.now().toString()
                    val prevEp = show.embedded?.previousepisode
                    val nextEp = show.embedded?.nextepisode
                    val displayEp = if (prevEp?.airdate == today) prevEp else nextEp
                    val displayItem = org.knp.bingeboard.data.model.WatchlistDisplayItem(
                        mediaType = "tv",
                        mediaId = show.id,
                        source = "tvmaze",
                        name = show.name,
                        posterUrl = show.image?.medium,
                        backdropPath = null,
                        voteAverage = show.rating?.average ?: 0.0,
                        status = show.status,
                        sortDate = displayEp?.airdate ?: show.schedule?.time?.takeIf { it.isNotBlank() },
                        nextEpisodeLabel = displayEp?.let { ep ->
                            "S${ep.season}E${ep.number}" + (" — ${ep.name}")
                        },
                        genres = show.genres.joinToString(", "),
                        airTimeDisplay = state.airTimeDisplay
                    )
                    watchlistRepository.addToWatchlist(displayItem)
                }
            }
            _uiState.value = _uiState.value.copy(isInWatchlist = !currentlyInList)
        }
    }

    fun retry() {
        loadDetails()
    }
}
