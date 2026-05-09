package org.knp.bingeboard.notifications

import android.Manifest
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.knp.bingeboard.MainActivity
import org.knp.bingeboard.R
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import javax.inject.Inject

@AndroidEntryPoint
class ShowAirReceiver : BroadcastReceiver() {

    @Inject lateinit var preferencesRepository: UserPreferencesRepository

    override fun onReceive(context: Context, intent: Intent) {
        val mediaId = intent.getIntExtra(EXTRA_MEDIA_ID, -1)
        if (mediaId == -1) return
        val showName = intent.getStringExtra(EXTRA_SHOW_NAME) ?: "Your show"
        val episodeLabel = intent.getStringExtra(EXTRA_EPISODE_LABEL)
        val source = intent.getStringExtra(EXTRA_SOURCE) ?: "tvmaze"
        val posterUrl = intent.getStringExtra(EXTRA_POSTER_URL)

        val pending = goAsync()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (!preferencesRepository.notificationsEnabled.first()) return@launch
                val poster = loadPosterBitmap(context, posterUrl)
                postNotification(context, mediaId, showName, episodeLabel, source, poster)
            } finally {
                pending.finish()
            }
        }
    }

    private fun postNotification(
        context: Context,
        mediaId: Int,
        showName: String,
        episodeLabel: String?,
        source: String,
        poster: Bitmap?
    ) {
        NotificationChannels.ensureCreated(context)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val granted = ContextCompat.checkSelfPermission(
                context, Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
            if (!granted) return
        }

        val launchIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            putExtra(EXTRA_MEDIA_ID, mediaId)
            putExtra(EXTRA_SOURCE, source)
        }
        val contentIntent = PendingIntent.getActivity(
            context,
            mediaId,
            launchIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val body = if (!episodeLabel.isNullOrBlank()) {
            "$episodeLabel is airing now"
        } else {
            "A new episode is airing now"
        }

        val builder = NotificationCompat.Builder(context, NotificationChannels.SHOW_AIRING)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(showName)
            .setContentText(body)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_REMINDER)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setAutoCancel(true)
            .setContentIntent(contentIntent)

        if (poster != null) {
            builder.setLargeIcon(poster)
            builder.setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(poster)
                    .bigLargeIcon(null as Bitmap?) // hide the large icon when expanded
                    .setBigContentTitle(showName)
                    .setSummaryText(body)
            )
        } else {
            builder.setStyle(NotificationCompat.BigTextStyle().bigText(body))
        }

        NotificationManagerCompat.from(context).notify(mediaId, builder.build())
    }

    companion object {
        const val EXTRA_MEDIA_ID = "extra_media_id"
        const val EXTRA_SHOW_NAME = "extra_show_name"
        const val EXTRA_EPISODE_LABEL = "extra_episode_label"
        const val EXTRA_SOURCE = "extra_source"
        const val EXTRA_POSTER_URL = "extra_poster_url"
    }
}
