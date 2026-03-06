package org.knp.bingeboard.data.repository;

import android.content.Context;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import kotlinx.coroutines.flow.Flow;
import org.knp.bingeboard.data.model.WatchlistDisplayItem;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Persists the user's watchlist as a JSON array in DataStore.
 * Now caching the full WatchlistDisplayItem to avoid API calls on load.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010!\u001a\u00020\tH\u0002J\u001e\u0010\"\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010#\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0002J\u001c\u0010%\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0086@\u00a2\u0006\u0002\u0010\'R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000Rz\u0010\n\u001an\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r \u000e*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\f0\f \u000e*6\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r \u000e*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\f0\f\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006("}, d2 = {"Lorg/knp/bingeboard/data/repository/WatchlistRepository;", "", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Landroid/content/Context;Lcom/squareup/moshi/Moshi;)V", "WATCHLIST_KEY", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "kotlin.jvm.PlatformType", "listType", "Ljava/lang/reflect/ParameterizedType;", "watchlist", "Lkotlinx/coroutines/flow/Flow;", "Lorg/knp/bingeboard/data/model/WatchlistDisplayItem;", "getWatchlist", "()Lkotlinx/coroutines/flow/Flow;", "addToWatchlist", "", "item", "(Lorg/knp/bingeboard/data/model/WatchlistDisplayItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isInWatchlist", "", "mediaType", "mediaId", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseEntries", "json", "removeFromWatchlist", "serializeEntries", "entries", "updateWatchlist", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WatchlistRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.squareup.moshi.Moshi moshi = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> WATCHLIST_KEY = null;
    private final java.lang.reflect.ParameterizedType listType = null;
    private final com.squareup.moshi.JsonAdapter<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> adapter = null;
    
    /**
     * Emits the full watchlist as a Flow
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<org.knp.bingeboard.data.model.WatchlistDisplayItem>> watchlist = null;
    
    @javax.inject.Inject()
    public WatchlistRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        super();
    }
    
    /**
     * Emits the full watchlist as a Flow
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<org.knp.bingeboard.data.model.WatchlistDisplayItem>> getWatchlist() {
        return null;
    }
    
    /**
     * Check if an item is in the watchlist
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isInWatchlist(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaType, int mediaId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Add a full item to the watchlist cache
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addToWatchlist(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.model.WatchlistDisplayItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Bulk update the watchlist cache
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateWatchlist(@org.jetbrains.annotations.NotNull()
    java.util.List<org.knp.bingeboard.data.model.WatchlistDisplayItem> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Remove an item from the watchlist
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeFromWatchlist(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaType, int mediaId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.util.List<org.knp.bingeboard.data.model.WatchlistDisplayItem> parseEntries(java.lang.String json) {
        return null;
    }
    
    private final java.lang.String serializeEntries(java.util.List<org.knp.bingeboard.data.model.WatchlistDisplayItem> entries) {
        return null;
    }
}