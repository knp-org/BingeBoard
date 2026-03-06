package org.knp.bingeboard.di;

import android.content.Context;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.knp.bingeboard.data.api.TvMazeApiService;
import org.knp.bingeboard.data.repository.LocaleOptionsProvider;
import org.knp.bingeboard.data.repository.UserPreferencesRepository;
import org.knp.bingeboard.data.repository.WatchlistRepository;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\u0016"}, d2 = {"Lorg/knp/bingeboard/di/AppModule;", "", "()V", "provideLocaleOptionsProvider", "Lorg/knp/bingeboard/data/repository/LocaleOptionsProvider;", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "provideMoshi", "provideTvMazeApiService", "Lorg/knp/bingeboard/data/api/TvMazeApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideTvMazeOkHttpClient", "Lokhttp3/OkHttpClient;", "provideTvMazeRetrofit", "okHttpClient", "provideUserPreferencesRepository", "Lorg/knp/bingeboard/data/repository/UserPreferencesRepository;", "provideWatchlistRepository", "Lorg/knp/bingeboard/data/repository/WatchlistRepository;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final org.knp.bingeboard.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.squareup.moshi.Moshi provideMoshi() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.repository.UserPreferencesRepository provideUserPreferencesRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "tvmaze")
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideTvMazeOkHttpClient() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "tvmaze")
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideTvMazeRetrofit(@javax.inject.Named(value = "tvmaze")
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.api.TvMazeApiService provideTvMazeApiService(@javax.inject.Named(value = "tvmaze")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.repository.LocaleOptionsProvider provideLocaleOptionsProvider(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.repository.WatchlistRepository provideWatchlistRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
}