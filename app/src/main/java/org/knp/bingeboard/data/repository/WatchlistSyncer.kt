package org.knp.bingeboard.data.repository

import kotlinx.coroutines.flow.first
import org.knp.bingeboard.data.mapper.toShowDetails
import org.knp.bingeboard.data.mapper.toWatchlistDisplayItem
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import org.knp.bingeboard.notifications.AirNotificationScheduler
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Refreshes every watchlist entry from the active source (TVmaze or TVDB),
 * persists the result, and reschedules air-time notifications.
 *
 * Shared by HomeViewModel (pull-to-refresh) and WatchlistRefreshWorker (daily background).
 */
@Singleton
class WatchlistSyncer @Inject constructor(
    private val watchlistRepository: WatchlistRepository,
    private val tvMazeRepository: TvMazeRepository,
    private val tvdbRepository: TvdbRepository,
    private val userPreferencesRepository: UserPreferencesRepository,
    private val airNotificationScheduler: AirNotificationScheduler
) {

    suspend fun sync() {
        val useTvdb = userPreferencesRepository.useTvdb.first()
        val entries = watchlistRepository.watchlist.first()
        val updated = mutableListOf<WatchlistDisplayItem>()

        for (entry in entries) {
            val refreshed = try {
                if (entry.mediaType == "tv") {
                    if (useTvdb) refreshFromTvdb(entry) else refreshFromTvMaze(entry)
                } else entry
            } catch (_: Exception) {
                entry
            }
            updated.add(refreshed)
        }

        watchlistRepository.updateWatchlist(updated)
        airNotificationScheduler.rescheduleAll(updated)
    }

    private suspend fun refreshFromTvMaze(entry: WatchlistDisplayItem): WatchlistDisplayItem {
        val mazeId = entry.tvmazeId ?: entry.mediaId
        val result = tvMazeRepository.getShowDetailsWithEpisodes(mazeId)
        val show = result.getOrNull() ?: return entry
        val airTimeInfo = tvMazeRepository.getAirTimeInfo(show)
        val showDetails = show.toShowDetails(
            airSchedule = airTimeInfo?.displayLabel,
            airTimestamp = airTimeInfo?.userDateTime?.toInstant()?.toEpochMilli()
        )
        return showDetails.toWatchlistDisplayItem()
    }

    private suspend fun refreshFromTvdb(entry: WatchlistDisplayItem): WatchlistDisplayItem {
        val tvdbId = entry.tvdbId ?: return entry
        val seriesResult = tvdbRepository.getSeries(tvdbId)
        val episodesResult = tvdbRepository.getSeriesEpisodes(tvdbId)
        val series = seriesResult.getOrNull()?.data ?: return entry
        val episodes = episodesResult.getOrNull()?.data?.episodes
        val nextEp = tvdbRepository.findLatestOrNextEpisode(episodes)
        val engName = series.translations?.nameTranslations
            ?.find { it.language == "eng" }?.name
        val showDetails = series.toShowDetails(
            nextEpisode = nextEp,
            airTimestamp = tvdbRepository.parseAirDate(nextEp?.aired, series.airsTime, series.originalCountry),
            tvmazeId = entry.tvmazeId,
            englishName = engName
        )
        return showDetails.toWatchlistDisplayItem()
    }
}
