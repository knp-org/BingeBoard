package org.knp.bingeboard.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.knp.bingeboard.data.api.TvMazeApiService
import org.knp.bingeboard.data.api.TvdbApiService
import org.knp.bingeboard.data.api.TvdbAuthInterceptor
import org.knp.bingeboard.data.repository.LocaleOptionsProvider
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import org.knp.bingeboard.data.repository.WatchlistRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserPreferencesRepository(
        @ApplicationContext context: Context
    ): UserPreferencesRepository {
        return UserPreferencesRepository(context)
    }

    // ── TVmaze ───────────────────────────────────────────────

    @Provides
    @Singleton
    @Named("tvmaze")
    fun provideTvMazeOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @Named("tvmaze")
    fun provideTvMazeRetrofit(
        @Named("tvmaze") okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideTvMazeApiService(@Named("tvmaze") retrofit: Retrofit): TvMazeApiService {
        return retrofit.create(TvMazeApiService::class.java)
    }

    // ── TVDB ─────────────────────────────────────────────────

    @Provides
    @Singleton
    @Named("tvdb")
    fun provideTvdbOkHttpClient(
        authInterceptor: TvdbAuthInterceptor
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @Named("tvdb")
    fun provideTvdbRetrofit(
        @Named("tvdb") okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api4.thetvdb.com/v4/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideTvdbApiService(@Named("tvdb") retrofit: Retrofit): TvdbApiService {
        return retrofit.create(TvdbApiService::class.java)
    }

    // ── Other ────────────────────────────────────────────────

    @Provides
    @Singleton
    fun provideLocaleOptionsProvider(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): LocaleOptionsProvider {
        return LocaleOptionsProvider(context, moshi)
    }

    @Provides
    @Singleton
    fun provideWatchlistRepository(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): WatchlistRepository {
        return WatchlistRepository(context, moshi)
    }
}
