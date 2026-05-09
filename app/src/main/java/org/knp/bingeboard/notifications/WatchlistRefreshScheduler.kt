package org.knp.bingeboard.notifications

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.concurrent.TimeUnit

/**
 * Schedules the watchlist refresh worker to run once a day around 6 AM local time.
 *
 * WorkManager periodic work doesn't support exact-time triggers — instead we enqueue
 * a one-time request with an initial delay until the next 6 AM, and the worker
 * re-enqueues itself for the following day at the end of each run.
 */
object WatchlistRefreshScheduler {

    private const val WORK_NAME = "watchlist_daily_refresh"
    private val TARGET_TIME: LocalTime = LocalTime.of(6, 0)

    fun scheduleNext(context: Context) {
        val delayMinutes = minutesUntilNext(TARGET_TIME)
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        val request = OneTimeWorkRequestBuilder<WatchlistRefreshWorker>()
            .setInitialDelay(delayMinutes, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context)
            .enqueueUniqueWork(WORK_NAME, ExistingWorkPolicy.REPLACE, request)
    }

    private fun minutesUntilNext(target: LocalTime): Long {
        val now = LocalDateTime.now()
        var next = LocalDateTime.of(LocalDate.now(), target)
        if (!next.isAfter(now)) next = next.plusDays(1)
        val zone = ZoneId.systemDefault()
        val diffMillis = next.atZone(zone).toInstant().toEpochMilli() -
            now.atZone(zone).toInstant().toEpochMilli()
        return TimeUnit.MILLISECONDS.toMinutes(diffMillis).coerceAtLeast(1)
    }
}
