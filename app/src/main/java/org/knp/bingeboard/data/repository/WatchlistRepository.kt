package org.knp.bingeboard.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import javax.inject.Inject
import javax.inject.Singleton

private val Context.watchlistDataStore by preferencesDataStore(name = "watchlist")

/**
 * Persists the user's watchlist as a JSON array in DataStore.
 * Now caching the full WatchlistDisplayItem to avoid API calls on load.
 */
@Singleton
class WatchlistRepository @Inject constructor(
    private val context: Context,
    private val moshi: Moshi
) {
    private val WATCHLIST_KEY = stringPreferencesKey("watchlist_entries")

    private val listType = Types.newParameterizedType(
        List::class.java,
        Map::class.java,
        String::class.java,
        Any::class.java
    )
    private val adapter = moshi.adapter<List<Map<String, Any>>>(listType)

    /** Emits the full watchlist as a Flow */
    val watchlist: Flow<List<WatchlistDisplayItem>> = context.watchlistDataStore.data.map { prefs ->
        val json = prefs[WATCHLIST_KEY] ?: "[]"
        parseEntries(json)
    }

    /** Check if an item is in the watchlist */
    suspend fun isInWatchlist(mediaType: String, mediaId: Int): Boolean {
        val entries = watchlist.first()
        return entries.any { it.mediaType == mediaType && it.mediaId == mediaId }
    }

    /** Add a full item to the watchlist cache */
    suspend fun addToWatchlist(item: WatchlistDisplayItem) {
        context.watchlistDataStore.edit { prefs ->
            val current = parseEntries(prefs[WATCHLIST_KEY] ?: "[]").toMutableList()
            // Remove existing if any, to update it
            current.removeAll { it.mediaType == item.mediaType && it.mediaId == item.mediaId }
            current.add(item)
            prefs[WATCHLIST_KEY] = serializeEntries(current)
        }
    }

    /** Bulk update the watchlist cache */
    suspend fun updateWatchlist(items: List<WatchlistDisplayItem>) {
        context.watchlistDataStore.edit { prefs ->
            prefs[WATCHLIST_KEY] = serializeEntries(items)
        }
    }

    /** Remove an item from the watchlist */
    suspend fun removeFromWatchlist(mediaType: String, mediaId: Int) {
        context.watchlistDataStore.edit { prefs ->
            val current = parseEntries(prefs[WATCHLIST_KEY] ?: "[]").toMutableList()
            current.removeAll { it.mediaType == mediaType && it.mediaId == mediaId }
            prefs[WATCHLIST_KEY] = serializeEntries(current)
        }
    }

    private fun parseEntries(json: String): List<WatchlistDisplayItem> {
        return try {
            val list = adapter.fromJson(json) ?: emptyList()
            list.mapNotNull { map ->
                val type = map["mediaType"] as? String ?: return@mapNotNull null
                val id = (map["mediaId"] as? Double)?.toInt() ?: return@mapNotNull null
                val source = map["source"] as? String ?: "tvmaze"
                
                // Read cached display fields or supply defaults for legacy entries
                // Legacy entries will need one API fetch on next load to populate these
                val name = map["name"] as? String ?: "Loading..."
                val posterUrl = map["posterUrl"] as? String
                val backdropPath = map["backdropPath"] as? String
                val voteAverage = (map["voteAverage"] as? Double) ?: 0.0
                val status = map["status"] as? String
                val sortDate = map["sortDate"] as? String
                val nextEpisodeLabel = map["nextEpisodeLabel"] as? String
                val genres = map["genres"] as? String ?: ""
                val airTimeDisplay = map["airTimeDisplay"] as? String
                val airTimestamp = (map["airTimestamp"] as? Number)?.toLong()

                WatchlistDisplayItem(
                    mediaType = type,
                    mediaId = id,
                    source = source,
                    name = name,
                    posterUrl = posterUrl,
                    backdropPath = backdropPath,
                    voteAverage = voteAverage,
                    status = status,
                    sortDate = sortDate,
                    nextEpisodeLabel = nextEpisodeLabel,
                    genres = genres,
                    airTimeDisplay = airTimeDisplay,
                    airTimestamp = airTimestamp
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun serializeEntries(entries: List<WatchlistDisplayItem>): String {
        val list = entries.map { item ->
            val map = mutableMapOf<String, Any>()
            map["mediaType"] = item.mediaType
            map["mediaId"] = item.mediaId
            map["source"] = item.source
            map["name"] = item.name
            map["voteAverage"] = item.voteAverage
            map["genres"] = item.genres
            item.posterUrl?.let { map["posterUrl"] = it }
            item.backdropPath?.let { map["backdropPath"] = it }
            item.status?.let { map["status"] = it }
            item.sortDate?.let { map["sortDate"] = it }
            item.nextEpisodeLabel?.let { map["nextEpisodeLabel"] = it }
            item.airTimeDisplay?.let { map["airTimeDisplay"] = it }
            item.airTimestamp?.let { map["airTimestamp"] = it }
            map
        }
        return adapter.toJson(list)
    }
}
