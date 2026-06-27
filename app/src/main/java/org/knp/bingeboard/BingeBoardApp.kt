package org.knp.bingeboard

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import org.knp.bingeboard.notifications.WatchlistRefreshScheduler
import javax.inject.Inject

@HiltAndroidApp
class BingeBoardApp : Application(), Configuration.Provider {

    @Inject lateinit var workerFactory: HiltWorkerFactory

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        super.onCreate()
        // Ensure the periodic refresh is always scheduled.
        // Uses KEEP policy internally, so this is safe to call on every launch.
        WatchlistRefreshScheduler.schedule(this)
    }
}
