package org.knp.bingeboard.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.app.Application
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import org.knp.bingeboard.data.repository.WatchlistRepository
import org.knp.bingeboard.data.repository.WatchlistSyncer
import org.knp.bingeboard.notifications.AirNotificationScheduler
import org.knp.bingeboard.notifications.WatchlistRefreshScheduler
import javax.inject.Inject

data class HomeUiState(
    val watchlistItems: List<WatchlistDisplayItem> = emptyList(),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val application: Application,
    private val watchlistRepository: WatchlistRepository,
    private val watchlistSyncer: WatchlistSyncer,
    private val airNotificationScheduler: AirNotificationScheduler
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            watchlistRepository.watchlist.collect { entries ->
                val filtered = entries.filter {
                    (it.source == "tvmaze" || it.source == "tvdb") && !it.isCompleted
                }
                val sorted = filtered.sortedWith(compareBy(nullsLast()) { it.sortDate })
                _uiState.value = _uiState.value.copy(
                    watchlistItems = sorted,
                    isLoading = false
                )

                airNotificationScheduler.rescheduleAll(entries)
            }
        }
        WatchlistRefreshScheduler.scheduleNext(application)
        refreshWatchlist()
    }

    fun loadWatchlist() {
        // Data is collected automatically via Flow.
    }

    fun refreshWatchlist() {
        viewModelScope.launch { syncWatchlist() }
    }

    suspend fun syncWatchlist() {
        _uiState.value = _uiState.value.copy(isRefreshing = true, error = null)
        watchlistSyncer.sync()
        _uiState.value = _uiState.value.copy(isRefreshing = false)
    }

    fun retry() = refreshWatchlist()
}
