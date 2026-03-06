package org.knp.bingeboard.data.repository;

import android.content.Context;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import org.knp.bingeboard.data.model.LocaleOption;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Provides locale options (regions, languages, timezones) loaded from JSON asset files.
 * This data is shared across all screens that need locale filtering.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002RJ\u0010\u0007\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u000b*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t \u000b*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u000b*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0014\u0010\u000eR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lorg/knp/bingeboard/data/repository/LocaleOptionsProvider;", "", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Landroid/content/Context;Lcom/squareup/moshi/Moshi;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lorg/knp/bingeboard/data/model/LocaleOption;", "kotlin.jvm.PlatformType", "languages", "getLanguages", "()Ljava/util/List;", "languages$delegate", "Lkotlin/Lazy;", "listType", "Ljava/lang/reflect/ParameterizedType;", "regions", "getRegions", "regions$delegate", "timezones", "getTimezones", "timezones$delegate", "loadFromAssets", "fileName", "", "app_debug"})
public final class LocaleOptionsProvider {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.squareup.moshi.Moshi moshi = null;
    private final java.lang.reflect.ParameterizedType listType = null;
    private final com.squareup.moshi.JsonAdapter<java.util.List<org.knp.bingeboard.data.model.LocaleOption>> adapter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy regions$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy languages$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy timezones$delegate = null;
    
    @javax.inject.Inject()
    public LocaleOptionsProvider(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.knp.bingeboard.data.model.LocaleOption> getRegions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.knp.bingeboard.data.model.LocaleOption> getLanguages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.knp.bingeboard.data.model.LocaleOption> getTimezones() {
        return null;
    }
    
    private final java.util.List<org.knp.bingeboard.data.model.LocaleOption> loadFromAssets(java.lang.String fileName) {
        return null;
    }
}