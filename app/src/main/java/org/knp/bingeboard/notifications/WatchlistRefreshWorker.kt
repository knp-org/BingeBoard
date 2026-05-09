package org.knp.bingeboard.notifications

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import org.knp.bingeboard.data.repository.WatchlistSyncer

@HiltWorker
class WatchlistRefreshWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val syncer: WatchlistSyncer
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            syncer.sync()
            WatchlistRefreshScheduler.scheduleNext(applicationContext)
            Result.success()
        } catch (_: Exception) {
            // Ensure we still keep the daily cadence even if a single run fails.
            WatchlistRefreshScheduler.scheduleNext(applicationContext)
            Result.retry()
        }
    }
}
