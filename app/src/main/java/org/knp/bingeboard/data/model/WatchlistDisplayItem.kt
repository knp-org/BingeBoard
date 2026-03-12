package org.knp.bingeboard.data.model

/**
 * Represents a single item in the home watchlist display and local cache.
 * Stores both API IDs so the app can switch between TVmaze and TVDB seamlessly.
 */
data class WatchlistDisplayItem(
    val mediaType: String,
    val mediaId: Int,              // primary ID used for the current source
    val source: String,            // "tvmaze" or "tvdb"
    val tvmazeId: Int? = null,     // TVmaze show ID (always populated from TVmaze)
    val tvdbId: Int? = null,       // TVDB series ID (from TVmaze externals or TVDB direct)
    val name: String,
    val posterUrl: String?,        // Full URL
    val backdropPath: String?,
    val voteAverage: Double,
    val status: String?,
    val sortDate: String?,         // the date used for sorting (next air date or release date)
    val nextEpisodeLabel: String?, // e.g. "S2E5 — Episode Name"
    val genres: String,            // comma-separated genre names
    val airTimeDisplay: String? = null, // e.g. "Sundays at 9:30 PM IST"
    val airTimestamp: Long? = null // to calculate countdown
)
