package org.knp.bingeboard.data.api

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import org.knp.bingeboard.data.repository.TvdbSessionManager
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import javax.inject.Inject

class TvdbAuthInterceptor @Inject constructor(
    private val sessionManager: TvdbSessionManager,
    private val userPreferencesRepository: UserPreferencesRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // Don't add auth token to login request
        if (originalRequest.url.encodedPath.endsWith("/login")) {
            return chain.proceed(originalRequest)
        }

        // Get token and language synchronously (OkHttp interceptors are synchronous)
        val token = runBlocking { sessionManager.getValidToken() }
        val language = runBlocking { userPreferencesRepository.language.first() }

        return if (token != null) {
            val authorizedRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .header("Accept", "application/json")
                .header("Accept-Language", language)
                .build()
            val response = chain.proceed(authorizedRequest)

            // If 401 Unauthorized, token might be expired
            if (response.code == 401) {
                runBlocking { sessionManager.clearToken() }
                response
            } else {
                response
            }
        } else {
            // No token available, just proceed (it will likely fail with 401)
            chain.proceed(
                originalRequest.newBuilder()
                    .header("Accept", "application/json")
                    .header("Accept-Language", language)
                    .build()
            )
        }
    }
}
