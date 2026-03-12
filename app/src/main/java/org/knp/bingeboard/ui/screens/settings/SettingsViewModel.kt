package org.knp.bingeboard.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.repository.LocaleOptionsProvider
import org.knp.bingeboard.data.repository.ThemeMode
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferencesRepository: UserPreferencesRepository,
    val localeOptionsProvider: LocaleOptionsProvider
) : ViewModel() {

    val themeMode: StateFlow<ThemeMode> = preferencesRepository.themeMode
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ThemeMode.SYSTEM_DEFAULT
        )

    val region: StateFlow<String> = preferencesRepository.region
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = "IN"
        )

    val language: StateFlow<String> = preferencesRepository.language
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = "en-US"
        )

    val timezone: StateFlow<String> = preferencesRepository.timezone
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = "Asia/Kolkata"
        )

    val tvdbApiKey: StateFlow<String> = preferencesRepository.tvdbApiKey
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ""
        )

    val useTvdb: StateFlow<Boolean> = preferencesRepository.useTvdb
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun updateThemeMode(mode: ThemeMode) {
        viewModelScope.launch {
            preferencesRepository.updateThemeMode(mode)
        }
    }

    fun updateRegion(region: String) {
        viewModelScope.launch {
            preferencesRepository.updateRegion(region)
        }
    }

    fun updateLanguage(language: String) {
        viewModelScope.launch {
            preferencesRepository.updateLanguage(language)
        }
    }

    fun updateTimezone(timezone: String) {
        viewModelScope.launch {
            preferencesRepository.updateTimezone(timezone)
        }
    }

    fun updateTvdbApiKey(apiKey: String) {
        viewModelScope.launch {
            preferencesRepository.updateTvdbApiKey(apiKey)
        }
    }

    fun updateUseTvdb(useTvdb: Boolean) {
        viewModelScope.launch {
            preferencesRepository.updateUseTvdb(useTvdb)
        }
    }
}
