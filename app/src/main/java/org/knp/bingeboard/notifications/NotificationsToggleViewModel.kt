package org.knp.bingeboard.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class NotificationsToggleViewModel @Inject constructor(
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    val enabled: StateFlow<Boolean> = preferencesRepository.notificationsEnabled
        .stateIn(viewModelScope, SharingStarted.Eagerly, true)

    fun toggle() {
        val next = !enabled.value
        viewModelScope.launch {
            preferencesRepository.updateNotificationsEnabled(next)
        }
    }
}
