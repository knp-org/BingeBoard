package org.knp.bingeboard.data.repository

import org.knp.bingeboard.data.api.TvMazeApiService
import org.knp.bingeboard.data.model.TvMazeEpisode
import org.knp.bingeboard.data.model.TvMazeSearchResult
import org.knp.bingeboard.data.model.TvMazeShow
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Holds the air-time info after timezone conversion.
 */
data class AirTimeInfo(
    val localTime: String,       // e.g. "9:30 PM IST"
    val days: String,            // e.g. "Sunday"
    val displayLabel: String,    // e.g. "Sunday at 9:30 PM IST"
    val userDateTime: ZonedDateTime? = null
)

@Singleton
class TvMazeRepository @Inject constructor(
    private val apiService: TvMazeApiService
) {

    /** Search TVmaze for TV shows by query */
    suspend fun searchShows(query: String): Result<List<TvMazeSearchResult>> {
        return try {
            Result.success(apiService.searchShows(query))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /** Get full show details by TVmaze ID (no embed — for detail page) */
    suspend fun getShowDetails(id: Int): Result<TvMazeShow> {
        return try {
            Result.success(apiService.getShowDetails(id))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /** Get TV schedule for a specific date and country */
    suspend fun getWebSchedule(date: String, countryCode: String?): Result<List<TvMazeEpisode>> {
        return try {
            Result.success(apiService.getWebSchedule(date, countryCode))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /** Get show details with episode info embedded (for watchlist) */
    suspend fun getShowDetailsWithEpisodes(id: Int): Result<TvMazeShow> {
        return try {
            Result.success(apiService.getShowDetailsWithEpisodes(id))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Look up a show on TVmaze. Uses IMDb ID if available (most reliable),
     * falls back to name search.
     */
    suspend fun lookupShow(imdbId: String?, showName: String): TvMazeShow? {
        if (!imdbId.isNullOrBlank()) {
            try {
                val show = apiService.lookupByImdb(imdbId)
                if (show != null) return show
            } catch (_: Exception) { }
        }
        return try {
            apiService.singleSearch(showName)
        } catch (_: Exception) {
            null
        }
    }

    /**
     * Convert the show's schedule time from its network timezone to the device's local timezone.
     */
    fun getAirTimeInfo(show: TvMazeShow): AirTimeInfo? {
        val scheduleTime = show.schedule?.time?.takeIf { it.isNotBlank() } ?: return null
        val days = show.schedule.days.takeIf { it.isNotEmpty() } ?: return null

        val networkTz = show.network?.country?.timezone
            ?: show.webChannel?.country?.timezone
            ?: return null

        return try {
            val sourceZone = ZoneId.of(networkTz)
            val userZone = ZoneId.systemDefault()

            val airTime = LocalTime.parse(scheduleTime, DateTimeFormatter.ofPattern("HH:mm"))

            val sourceDateTime = ZonedDateTime.now(sourceZone)
                .withHour(airTime.hour)
                .withMinute(airTime.minute)
                .withSecond(0)
                .withNano(0)

            val userDateTime = sourceDateTime.withZoneSameInstant(userZone)

            val timeFormatter = DateTimeFormatter.ofPattern("h:mm a z")
            val localTimeStr = userDateTime.format(timeFormatter)

            val daysStr = days.joinToString(", ")

            AirTimeInfo(
                localTime = localTimeStr,
                days = daysStr,
                displayLabel = "$daysStr at $localTimeStr",
                userDateTime = userDateTime
            )
        } catch (e: Exception) {
            null
        }
    }

    /** Strip HTML tags from TVmaze summary */
    fun cleanSummary(html: String?): String {
        return html?.replace(Regex("<[^>]*>"), "")?.trim() ?: ""
    }

    /** Convert TV Maze airstamp (ISO 8601) to epoch milliseconds */
    fun parseAirstamp(airstamp: String?): Long? {
        if (airstamp.isNullOrBlank()) return null
        return try {
            ZonedDateTime.parse(airstamp).toInstant().toEpochMilli()
        } catch (e: Exception) {
            null
        }
    }
}
