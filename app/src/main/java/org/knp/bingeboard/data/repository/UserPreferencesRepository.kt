package org.knp.bingeboard.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

enum class ThemeMode {
    SYSTEM_DEFAULT,
    LIGHT,
    DARK
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "binge_board_preferences")

@Singleton
class UserPreferencesRepository @Inject constructor(
    private val context: Context
) {
    private object PreferencesKeys {
        val THEME_MODE = intPreferencesKey("theme_mode")
        val REGION = stringPreferencesKey("region")
        val LANGUAGE = stringPreferencesKey("language")
        val TIMEZONE = stringPreferencesKey("timezone")
        val TVDB_API_KEY = stringPreferencesKey("tvdb_api_key")
        val USE_TVDB = androidx.datastore.preferences.core.booleanPreferencesKey("use_tvdb")
    }

    val themeMode: Flow<ThemeMode> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }
        .map { preferences ->
            when (preferences[PreferencesKeys.THEME_MODE]) {
                ThemeMode.LIGHT.ordinal -> ThemeMode.LIGHT
                ThemeMode.DARK.ordinal -> ThemeMode.DARK
                else -> ThemeMode.SYSTEM_DEFAULT
            }
        }

    val region: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }
        .map { preferences ->
            preferences[PreferencesKeys.REGION] ?: "IN"
        }

    val language: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }
        .map { preferences ->
            preferences[PreferencesKeys.LANGUAGE] ?: "en-US"
        }

    val timezone: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }
        .map { preferences ->
            preferences[PreferencesKeys.TIMEZONE] ?: "Asia/Kolkata"
        }

    val tvdbApiKey: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }
        .map { preferences ->
            preferences[PreferencesKeys.TVDB_API_KEY] ?: ""
        }

    val useTvdb: Flow<Boolean> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }
        .map { preferences ->
            preferences[PreferencesKeys.USE_TVDB] ?: false
        }

    suspend fun updateThemeMode(themeMode: ThemeMode) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.THEME_MODE] = themeMode.ordinal
        }
    }

    suspend fun updateRegion(region: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.REGION] = region
        }
    }

    suspend fun updateLanguage(language: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.LANGUAGE] = language
        }
    }

    suspend fun updateTimezone(timezone: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.TIMEZONE] = timezone
        }
    }

    suspend fun updateTvdbApiKey(apiKey: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.TVDB_API_KEY] = apiKey
        }
    }

    suspend fun updateUseTvdb(useTvdb: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USE_TVDB] = useTvdb
        }
    }
}
