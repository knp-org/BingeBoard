package org.knp.bingeboard.ui.screens.tv

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.model.TvMazeEpisode
import org.knp.bingeboard.data.repository.TvMazeRepository
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

data class TvUiState(
    val isLoading: Boolean = false,
    val episodes: List<TvMazeEpisode> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class TvViewModel @Inject constructor(
    private val tvMazeRepository: TvMazeRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TvUiState())
    val uiState: StateFlow<TvUiState> = _uiState.asStateFlow()

    init {
        loadSchedule()
    }

    fun loadSchedule() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            try {
                // Get region from user preferences
                val region = userPreferencesRepository.region.first()
                
                // Get today's date in yyyy-MM-dd format
                // The API actually wants country, and the instructions specify using Region from settings 
                // However, the example URL used US. We will try to pass the region directly.
                val today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
                
                val result = tvMazeRepository.getWebSchedule(today, region)
                
                result.onSuccess { episodes ->
                    // Filter out episodes without an embedded show just in case
                    val validEpisodes = episodes.filter { it.embedded?.show != null }
                    _uiState.value = TvUiState(
                        isLoading = false,
                        episodes = validEpisodes,
                        error = if (validEpisodes.isEmpty()) "No shows scheduled for today in $region." else null
                    )
                }.onFailure { error ->
                    _uiState.value = TvUiState(
                        isLoading = false,
                        error = error.localizedMessage ?: "Failed to load schedule"
                    )
                }
            } catch (e: Exception) {
                _uiState.value = TvUiState(
                    isLoading = false,
                    error = "An unexpected error occurred."
                )
            }
        }
    }
}
