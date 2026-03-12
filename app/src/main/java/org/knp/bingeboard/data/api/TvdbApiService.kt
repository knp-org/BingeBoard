package org.knp.bingeboard.data.api

import org.knp.bingeboard.data.model.TvdbEpisodesResponse
import org.knp.bingeboard.data.model.TvdbLoginRequest
import org.knp.bingeboard.data.model.TvdbLoginResponse
import org.knp.bingeboard.data.model.TvdbSearchResponse
import org.knp.bingeboard.data.model.TvdbSeriesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TvdbApiService {

    @POST("login")
    suspend fun login(@Body request: TvdbLoginRequest): TvdbLoginResponse

    @GET("search")
    suspend fun search(
        @Query("query") query: String,
        @Query("type") type: String = "series"
    ): TvdbSearchResponse

    @GET("series/{id}/extended")
    suspend fun getSeries(
        @Path("id") id: Int,
        @Query("meta") meta: String? = "translations"
    ): TvdbSeriesResponse

    // Gets episodes for the series. Default returns translated episodes if available.
    @GET("series/{id}/episodes/default")
    suspend fun getSeriesEpisodes(
        @Path("id") id: Int,
        @Query("page") page: Int = 0
    ): TvdbEpisodesResponse
}
