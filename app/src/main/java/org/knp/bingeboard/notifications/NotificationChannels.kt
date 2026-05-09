package org.knp.bingeboard.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.getSystemService

object NotificationChannels {
    const val SHOW_AIRING = "show_airing"

    fun ensureCreated(context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val manager = context.getSystemService<NotificationManager>() ?: return
        if (manager.getNotificationChannel(SHOW_AIRING) != null) return

        val channel = NotificationChannel(
            SHOW_AIRING,
            "Show airing",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Notifies when a show on your watchlist starts airing"
            enableLights(true)
            enableVibration(true)
        }
        manager.createNotificationChannel(channel)
    }
}
