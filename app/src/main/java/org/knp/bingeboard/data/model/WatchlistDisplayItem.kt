package org.knp.bingeboard.data.model

/**
 * Represents a single item in the home watchlist display and local cache.
 */
data class WatchlistDisplayItem(
    val mediaType: String,
    val mediaId: Int,
    val source: String,           // "tvmaze"
    val name: String,
    val posterUrl: String?,       // Full URL from TVmaze
    val backdropPath: String?,
    val voteAverage: Double,
    val status: String?,
    val sortDate: String?,        // the date used for sorting (next air date or release date)
    val nextEpisodeLabel: String?, // e.g. "S2E5 — Episode Name"
    val genres: String,           // comma-separated genre names
    val airTimeDisplay: String? = null, // e.g. "Sundays at 9:30 PM IST"
    val airTimestamp: Long? = null // to calculate countdown
)
