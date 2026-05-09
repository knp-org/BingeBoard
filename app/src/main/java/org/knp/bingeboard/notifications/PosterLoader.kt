package org.knp.bingeboard.notifications

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ImageRequest

/**
 * Synchronously fetches a remote poster URL into a [Bitmap] for use as a
 * notification large icon / big-picture. Returns null if the URL is blank
 * or the load fails.
 *
 * Must be called from a coroutine — Coil's `execute` is suspending.
 */
suspend fun loadPosterBitmap(context: Context, url: String?): Bitmap? {
    if (url.isNullOrBlank()) return null
    return try {
        val request = ImageRequest.Builder(context)
            .data(url)
            .allowHardware(false)
            .build()
        val result = ImageLoader(context).execute(request)
        (result.drawable as? BitmapDrawable)?.bitmap
    } catch (_: Exception) {
        null
    }
}
