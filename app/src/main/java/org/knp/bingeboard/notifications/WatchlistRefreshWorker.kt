package org.knp.bingeboard.notifications

import android.content.Context
import android.util.Log
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
        Log.d("WatchlistRefreshWorker", "Background sync started (attempt $runAttemptCount)")
        return try {
            syncer.sync()
            Log.d("WatchlistRefreshWorker", "Background sync completed successfully")
            Result.success()
        } catch (e: Exception) {
            Log.e("WatchlistRefreshWorker", "Background sync failed", e)
            // Retry up to 3 times, then report failure.
            // PeriodicWork will still fire on the next period regardless.
            if (runAttemptCount < 3) Result.retry() else Result.failure()
        }
    }
}
