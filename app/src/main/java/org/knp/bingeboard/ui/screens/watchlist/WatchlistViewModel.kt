package org.knp.bingeboard.ui.screens.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import org.knp.bingeboard.data.repository.WatchlistRepository
import javax.inject.Inject

data class WatchlistUiState(
    val isLoading: Boolean = true,
    val items: List<WatchlistDisplayItem> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WatchlistUiState())
    val uiState: StateFlow<WatchlistUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            watchlistRepository.watchlist.collect { entries ->
                val completed = entries
                    .filter { (it.source == "tvmaze" || it.source == "tvdb") && it.isCompleted }
                    .sortedBy { it.name.lowercase() }
                _uiState.value = WatchlistUiState(
                    isLoading = false,
                    items = completed,
                    error = null
                )
            }
        }
    }

    fun refresh() {
        // Watchlist is collected via Flow; no remote refresh needed for completed shows.
    }
}
