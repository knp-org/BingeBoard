package org.knp.bingeboard.data.model

import com.squareup.moshi.Json

/**
 * Wrapper for TVmaze search results: /search/shows?q=...
 */
data class TvMazeSearchResult(
    @Json(name = "score") val score: Double = 0.0,
    @Json(name = "show") val show: TvMazeShow
)

/**
 * Full TVmaze show object.
 */
data class TvMazeShow(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: String? = null,
    @Json(name = "language") val language: String? = null,
    @Json(name = "genres") val genres: List<String> = emptyList(),
    @Json(name = "status") val status: String? = null,
    @Json(name = "runtime") val runtime: Int? = null,
    @Json(name = "averageRuntime") val averageRuntime: Int? = null,
    @Json(name = "premiered") val premiered: String? = null,
    @Json(name = "ended") val ended: String? = null,
    @Json(name = "officialSite") val officialSite: String? = null,
    @Json(name = "schedule") val schedule: TvMazeSchedule? = null,
    @Json(name = "rating") val rating: TvMazeRating? = null,
    @Json(name = "weight") val weight: Int = 0,
    @Json(name = "network") val network: TvMazeNetwork? = null,
    @Json(name = "webChannel") val webChannel: TvMazeNetwork? = null,
    @Json(name = "externals") val externals: TvMazeExternals? = null,
    @Json(name = "image") val image: TvMazeImage? = null,
    @Json(name = "summary") val summary: String? = null,
    @Json(name = "_embedded") val embedded: TvMazeEmbedded? = null
)

data class TvMazeEmbedded(
    @Json(name = "nextepisode") val nextepisode: TvMazeEpisode? = null,
    @Json(name = "previousepisode") val previousepisode: TvMazeEpisode? = null
)

data class TvMazeEpisodeEmbedded(
    @Json(name = "show") val show: TvMazeShow? = null
)

data class TvMazeEpisode(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "season") val season: Int,
    @Json(name = "number") val number: Int,
    @Json(name = "airdate") val airdate: String? = null,
    @Json(name = "airtime") val airtime: String? = null,
    @Json(name = "airstamp") val airstamp: String? = null,
    @Json(name = "_embedded") val embedded: TvMazeEpisodeEmbedded? = null
)

data class TvMazeSchedule(
    @Json(name = "time") val time: String? = null,
    @Json(name = "days") val days: List<String> = emptyList()
)

data class TvMazeRating(
    @Json(name = "average") val average: Double? = null
)

data class TvMazeNetwork(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "name") val name: String? = null,
    @Json(name = "country") val country: TvMazeCountry? = null,
    @Json(name = "officialSite") val officialSite: String? = null
)

data class TvMazeCountry(
    @Json(name = "name") val name: String? = null,
    @Json(name = "code") val code: String? = null,
    @Json(name = "timezone") val timezone: String? = null
)

data class TvMazeExternals(
    @Json(name = "tvrage") val tvrage: Int? = null,
    @Json(name = "thetvdb") val thetvdb: Int? = null,
    @Json(name = "imdb") val imdb: String? = null
)

data class TvMazeImage(
    @Json(name = "medium") val medium: String? = null,
    @Json(name = "original") val original: String? = null
)
