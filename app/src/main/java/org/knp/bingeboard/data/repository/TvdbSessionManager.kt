package org.knp.bingeboard.data.repository

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.knp.bingeboard.data.api.TvdbApiService
import org.knp.bingeboard.data.model.TvdbLoginRequest
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class TvdbSessionManager @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository,
    // Using Provider to break circular dependency (Manager -> ApiService -> Interceptor -> Manager)
    private val tvdbApiServiceProvider: Provider<TvdbApiService> 
) {
    private var currentToken: String? = null
    private val mutex = Mutex()

    /**
     * Returns a valid JWT token, fetching a new one if necessary.
     */
    suspend fun getValidToken(): String? {
        return mutex.withLock {
            if (currentToken != null) {
                // TODO: Store token expiry and check it here. For now, we clear it on 401.
                return@withLock currentToken
            }
            fetchNewToken()
        }
    }

    suspend fun clearToken() {
        mutex.withLock {
            currentToken = null
        }
    }

    private suspend fun fetchNewToken(): String? {
        val apiKey = userPreferencesRepository.tvdbApiKey.first()
        if (apiKey.isBlank()) return null

        return try {
            val response = tvdbApiServiceProvider.get().login(TvdbLoginRequest(apikey = apiKey))
            response.data?.token?.also { token ->
                currentToken = token
            }
        } catch (e: Exception) {
            null
        }
    }
}
