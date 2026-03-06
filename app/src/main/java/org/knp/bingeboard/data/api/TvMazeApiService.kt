package org.knp.bingeboard.data.api

import org.knp.bingeboard.data.model.TvMazeEpisode
import org.knp.bingeboard.data.model.TvMazeSearchResult
import org.knp.bingeboard.data.model.TvMazeShow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvMazeApiService {

    /** Search shows by name — returns scored results */
    @GET("search/shows")
    suspend fun searchShows(
        @Query("q") query: String
    ): List<TvMazeSearchResult>

    /** Get full show details by TVmaze ID (no embed — for detail page) */
    @GET("shows/{id}")
    suspend fun getShowDetails(
        @Path("id") id: Int
    ): TvMazeShow

    /** Get show details with next/previous episode embedded (for watchlist) */
    @GET("shows/{id}")
    suspend fun getShowDetailsWithEpisodes(
        @Path("id") id: Int,
        @Query("embed[]") embed: List<String> = listOf("nextepisode", "previousepisode")
    ): TvMazeShow

    /** Lookup a show by IMDb ID */
    @GET("lookup/shows")
    suspend fun lookupByImdb(
        @Query("imdb") imdbId: String
    ): TvMazeShow?

    /** Search by name — returns single best match */
    @GET("singlesearch/shows")
    suspend fun singleSearch(
        @Query("q") query: String
    ): TvMazeShow?

    /** Get TV schedule for a specific date and country */
    @GET("schedule/web")
    suspend fun getWebSchedule(
        @Query("date") date: String,
        @Query("country") countryCode: String? = null
    ): List<TvMazeEpisode>
}
