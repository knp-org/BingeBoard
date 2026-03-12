package org.knp.bingeboard.data.model

import java.util.UUID

/**
 * Data source identifier for TV show data.
 */
enum class Source(val value: Int) {
    TVMAZE(1),
    TVDB(2);

    companion object {
        fun fromValue(value: Int): Source = entries.first { it.value == value }
        fun fromString(name: String): Source = when (name.lowercase()) {
            "tvmaze" -> TVMAZE
            "tvdb" -> TVDB
            else -> TVMAZE
        }
    }
}

/**
 * Unified show model consumed by all UI and storage layers.
 * API-specific models (TvMazeShow, TvdbSeries) are mapped into this.
 */
data class ShowDetails(
    val id: String = UUID.randomUUID().toString(),
    val source: Source,
    val tvmazeId: Int? = null,         // TVmaze show ID
    val tvdbId: Int? = null,           // TVDB series ID
    val name: String,
    val posterUrl: String?,
    val backdropUrl: String?,
    val rating: Double?,
    val status: String?,
    val premiered: String?,            // "yyyy-MM-dd"
    val ended: String?,
    val genres: List<String>,
    val summary: String?,
    val network: String?,
    val runtime: Int?,
    val language: String?,
    val officialSite: String?,
    val nextEpisode: EpisodeInfo?,
    val airSchedule: String?,          // e.g. "Sundays at 9:30 PM IST"
    val airTimestamp: Long?             // epoch millis for countdown timer
)

/**
 * Minimal episode info for the next/latest episode display.
 */
data class EpisodeInfo(
    val season: Int,
    val number: Int,
    val name: String?,
    val airDate: String?               // "yyyy-MM-dd"
)
