package org.knp.bingeboard.notifications

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

/**
 * Schedules the watchlist refresh worker to run periodically.
 *
 * Uses PeriodicWorkRequest (every 6 hours) instead of chained one-time requests.
 * This is far more reliable on Samsung/OEM devices with aggressive battery
 * management, because WorkManager treats periodic work as a persistent job
 * that survives Doze, app standby, and OEM battery killers.
 *
 * The KEEP policy ensures re-calling schedule() (e.g. on every app launch)
 * is idempotent — it won't cancel or reset the existing schedule.
 */
object WatchlistRefreshScheduler {

    private const val TAG = "WatchlistRefreshScheduler"
    private const val WORK_NAME = "watchlist_periodic_refresh"

    fun schedule(context: Context) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            // Removed setRequiresBatteryNotLow — Samsung reports "battery low"
            // even at high charge, which prevents the worker from running.
            .build()

        val request = PeriodicWorkRequestBuilder<WatchlistRefreshWorker>(
            6, TimeUnit.HOURS,           // repeat interval
            30, TimeUnit.MINUTES         // flex interval — run within the last 30m of each period
        )
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,  // Don't reset if already scheduled
                request
            )

        Log.d(TAG, "Periodic watchlist refresh scheduled (every 6 hours)")
    }
}
