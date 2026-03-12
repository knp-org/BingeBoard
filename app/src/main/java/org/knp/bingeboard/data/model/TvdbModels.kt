package org.knp.bingeboard.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// ── Authentication ──────────────────────────────────────────────
data class TvdbLoginRequest(
    @Json(name = "apikey") val apikey: String,
    @Json(name = "pin") val pin: String = ""
)

data class TvdbLoginResponse(
    @Json(name = "data") val data: TvdbLoginData? = null
)

data class TvdbLoginData(
    @Json(name = "token") val token: String
)

// ── Search ──────────────────────────────────────────────────────
data class TvdbSearchResponse(
    @Json(name = "data") val data: List<TvdbSearchResult>? = null
)

data class TvdbSearchResult(
    @Json(name = "tvdb_id") val tvdb_id: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "image_url") val image_url: String? = null,
    @Json(name = "year") val year: String? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "overview") val overview: String? = null
)

// ── Series Details ──────────────────────────────────────────────
data class TvdbSeriesResponse(
    @Json(name = "data") val data: TvdbSeries? = null
)

data class TvdbSeries(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: String? = null,
    @Json(name = "score") val score: Double? = null,
    @Json(name = "status") val status: TvdbStatus? = null,
    @Json(name = "firstAired") val firstAired: String? = null,
    @Json(name = "genres") val genres: List<TvdbGenre>? = null,
    @Json(name = "overview") val overview: String? = null,
    @Json(name = "nextAired") val nextAired: String? = null,
    @Json(name = "airsTime") val airsTime: String? = null,
    @Json(name = "originalCountry") val originalCountry: String? = null,
    @Json(name = "translations") val translations: TvdbSeriesTranslations? = null
)

data class TvdbSeriesTranslations(
    @Json(name = "nameTranslations") val nameTranslations: List<TvdbTranslationObj>? = null,
    @Json(name = "overviewTranslations") val overviewTranslations: List<TvdbTranslationObj>? = null,
    @Json(name = "aliases") val aliases: List<String>? = null
)

data class TvdbTranslationObj(
    @Json(name = "name") val name: String? = null,
    @Json(name = "overview") val overview: String? = null,
    @Json(name = "language") val language: String? = null,
    @Json(name = "isPrimary") val isPrimary: Boolean? = null
)

data class TvdbStatus(
    @Json(name = "name") val name: String? = null
)

data class TvdbGenre(
    @Json(name = "name") val name: String? = null
)

// ── Episodes ────────────────────────────────────────────────────
data class TvdbEpisodesResponse(
    @Json(name = "data") val data: TvdbEpisodesData? = null
)

data class TvdbEpisodesData(
    @Json(name = "episodes") val episodes: List<TvdbEpisode>? = null
)

data class TvdbEpisode(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String? = null,
    @Json(name = "seasonNumber") val seasonNumber: Int,
    @Json(name = "number") val number: Int,
    @Json(name = "aired") val aired: String? = null,
    @Json(name = "overview") val overview: String? = null,
    @Json(name = "image") val image: String? = null
)


