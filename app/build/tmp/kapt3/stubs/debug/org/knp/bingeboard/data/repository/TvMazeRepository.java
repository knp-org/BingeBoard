package org.knp.bingeboard.data.repository;

import org.knp.bingeboard.data.api.TvMazeApiService;
import org.knp.bingeboard.data.model.TvMazeEpisode;
import org.knp.bingeboard.data.model.TvMazeSearchResult;
import org.knp.bingeboard.data.model.TvMazeShow;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0011J4\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\r2\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010!J*\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00150\r2\u0006\u0010$\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b%\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\'"}, d2 = {"Lorg/knp/bingeboard/data/repository/TvMazeRepository;", "", "apiService", "Lorg/knp/bingeboard/data/api/TvMazeApiService;", "(Lorg/knp/bingeboard/data/api/TvMazeApiService;)V", "cleanSummary", "", "html", "getAirTimeInfo", "Lorg/knp/bingeboard/data/repository/AirTimeInfo;", "show", "Lorg/knp/bingeboard/data/model/TvMazeShow;", "getShowDetails", "Lkotlin/Result;", "id", "", "getShowDetails-gIAlu-s", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShowDetailsWithEpisodes", "getShowDetailsWithEpisodes-gIAlu-s", "getWebSchedule", "", "Lorg/knp/bingeboard/data/model/TvMazeEpisode;", "date", "countryCode", "getWebSchedule-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookupShow", "imdbId", "showName", "parseAirstamp", "", "airstamp", "(Ljava/lang/String;)Ljava/lang/Long;", "searchShows", "Lorg/knp/bingeboard/data/model/TvMazeSearchResult;", "query", "searchShows-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TvMazeRepository {
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.api.TvMazeApiService apiService = null;
    
    @javax.inject.Inject()
    public TvMazeRepository(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.api.TvMazeApiService apiService) {
        super();
    }
    
    /**
     * Look up a show on TVmaze. Uses IMDb ID if available (most reliable),
     * falls back to name search.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object lookupShow(@org.jetbrains.annotations.Nullable()
    java.lang.String imdbId, @org.jetbrains.annotations.NotNull()
    java.lang.String showName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.knp.bingeboard.data.model.TvMazeShow> $completion) {
        return null;
    }
    
    /**
     * Convert the show's schedule time from its network timezone to the device's local timezone.
     */
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.repository.AirTimeInfo getAirTimeInfo(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.model.TvMazeShow show) {
        return null;
    }
    
    /**
     * Strip HTML tags from TVmaze summary
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String cleanSummary(@org.jetbrains.annotations.Nullable()
    java.lang.String html) {
        return null;
    }
    
    /**
     * Convert TV Maze airstamp (ISO 8601) to epoch milliseconds
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long parseAirstamp(@org.jetbrains.annotations.Nullable()
    java.lang.String airstamp) {
        return null;
    }
}