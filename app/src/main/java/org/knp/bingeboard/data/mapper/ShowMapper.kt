package org.knp.bingeboard.data.mapper

import org.knp.bingeboard.data.model.EpisodeInfo
import org.knp.bingeboard.data.model.ShowDetails
import org.knp.bingeboard.data.model.Source
import org.knp.bingeboard.data.model.TvMazeShow
import org.knp.bingeboard.data.model.TvdbEpisode
import org.knp.bingeboard.data.model.TvdbSeries
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import java.time.LocalDate

// ── TVmaze → ShowDetails ────────────────────────────────────────

fun TvMazeShow.toShowDetails(
    airSchedule: String? = null,
    airTimestamp: Long? = null
): ShowDetails {
    val today = LocalDate.now().toString()
    val prevEp = embedded?.previousepisode
    val nextEp = embedded?.nextepisode
    val displayEp = if (prevEp?.airdate == today) prevEp else nextEp

    return ShowDetails(
        source = Source.TVMAZE,
        tvmazeId = id,
        tvdbId = externals?.thetvdb,    // cross-reference: TVmaze stores TVDB ID
        name = name,
        posterUrl = image?.original ?: image?.medium,
        backdropUrl = image?.original,
        rating = rating?.average,
        status = status,
        premiered = premiered,
        ended = ended,
        genres = genres,
        summary = summary?.replace(Regex("<[^>]*>"), "")?.trim(),
        network = network?.name ?: webChannel?.name,
        runtime = averageRuntime ?: runtime,
        language = language,
        officialSite = officialSite,
        nextEpisode = displayEp?.let { ep ->
            EpisodeInfo(
                season = ep.season,
                number = ep.number,
                name = ep.name,
                airDate = ep.airdate
            )
        },
        airSchedule = airSchedule,
        airTimestamp = airTimestamp
    )
}

// ── TVDB → ShowDetails ──────────────────────────────────────────

fun TvdbSeries.toShowDetails(
    nextEpisode: TvdbEpisode? = null,
    airTimestamp: Long? = null,
    tvmazeId: Int? = null               // pass existing TVmaze ID if known
): ShowDetails {
    return ShowDetails(
        source = Source.TVDB,
        tvmazeId = tvmazeId,
        tvdbId = id,
        name = name,
        posterUrl = image,
        backdropUrl = image,
        rating = score,
        status = status?.name,
        premiered = firstAired,
        ended = null,
        genres = genres?.mapNotNull { it.name } ?: emptyList(),
        summary = overview?.replace(Regex("<[^>]*>"), "")?.trim(),
        network = null,
        runtime = null,
        language = null,
        officialSite = null,
        nextEpisode = nextEpisode?.let { ep ->
            EpisodeInfo(
                season = ep.seasonNumber,
                number = ep.number,
                name = ep.name,
                airDate = ep.aired
            )
        },
        airSchedule = null,
        airTimestamp = airTimestamp
    )
}

// ── ShowDetails → WatchlistDisplayItem ──────────────────────────

fun ShowDetails.toWatchlistDisplayItem(): WatchlistDisplayItem {
    // mediaId = the ID for the current source
    val primaryId = when (source) {
        Source.TVMAZE -> tvmazeId ?: 0
        Source.TVDB -> tvdbId ?: 0
    }
    return WatchlistDisplayItem(
        mediaType = "tv",
        mediaId = primaryId,
        source = source.name.lowercase(),
        tvmazeId = tvmazeId,
        tvdbId = tvdbId,
        name = name,
        posterUrl = posterUrl,
        backdropPath = backdropUrl,
        voteAverage = rating ?: 0.0,
        status = status,
        sortDate = nextEpisode?.airDate ?: premiered,
        nextEpisodeLabel = nextEpisode?.let { ep ->
            "S${ep.season}E${ep.number}" + (ep.name?.let { " — $it" } ?: "")
        },
        genres = genres.joinToString(", "),
        airTimeDisplay = airSchedule,
        airTimestamp = airTimestamp
    )
}
