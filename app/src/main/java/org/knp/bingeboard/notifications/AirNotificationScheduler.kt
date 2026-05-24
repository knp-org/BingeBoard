package org.knp.bingeboard.notifications

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.content.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AirNotificationScheduler @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val alarmManager: AlarmManager? = context.getSystemService()

    fun rescheduleAll(items: List<WatchlistDisplayItem>) {
        NotificationChannels.ensureCreated(context)
        val now = System.currentTimeMillis()
        items.forEach { item ->
            cancel(item.mediaId)
            val ts = item.airTimestamp ?: return@forEach
            if (ts <= now) return@forEach
            if (item.isCompleted) return@forEach
            schedule(item, ts)
        }
    }

    fun cancelAll(items: List<WatchlistDisplayItem>) {
        items.forEach { cancel(it.mediaId) }
    }

    private fun schedule(item: WatchlistDisplayItem, triggerAtMillis: Long) {
        val am = alarmManager ?: return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !am.canScheduleExactAlarms()) {
            // Fall back to inexact — better late than never.
            am.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent(item))
            return
        }
        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent(item))
    }

    private fun cancel(mediaId: Int) {
        alarmManager?.cancel(cancelPendingIntent(mediaId))
    }

    private fun pendingIntent(item: WatchlistDisplayItem): PendingIntent {
        val intent = Intent(context, ShowAirReceiver::class.java).apply {
            putExtra(ShowAirReceiver.EXTRA_MEDIA_ID, item.mediaId)
            putExtra(ShowAirReceiver.EXTRA_SHOW_NAME, item.englishName ?: item.name)
            putExtra(ShowAirReceiver.EXTRA_EPISODE_LABEL, item.nextEpisodeLabel)
            putExtra(ShowAirReceiver.EXTRA_SOURCE, item.source)
            putExtra(ShowAirReceiver.EXTRA_POSTER_URL, item.posterUrl)
        }
        return PendingIntent.getBroadcast(
            context,
            item.mediaId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    private fun cancelPendingIntent(mediaId: Int): PendingIntent {
        val intent = Intent(context, ShowAirReceiver::class.java)
        return PendingIntent.getBroadcast(
            context,
            mediaId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
}
