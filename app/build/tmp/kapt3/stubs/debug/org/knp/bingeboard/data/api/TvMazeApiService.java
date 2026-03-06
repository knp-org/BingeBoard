package org.knp.bingeboard.data.api;

import org.knp.bingeboard.data.model.TvMazeEpisode;
import org.knp.bingeboard.data.model.TvMazeSearchResult;
import org.knp.bingeboard.data.model.TvMazeShow;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\b\b\u0001\u0010\u000e\u001a\u00020\n2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\nH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0012\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\b\b\u0001\u0010\u0016\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0016\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lorg/knp/bingeboard/data/api/TvMazeApiService;", "", "getShowDetails", "Lorg/knp/bingeboard/data/model/TvMazeShow;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShowDetailsWithEpisodes", "embed", "", "", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWebSchedule", "Lorg/knp/bingeboard/data/model/TvMazeEpisode;", "date", "countryCode", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookupByImdb", "imdbId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchShows", "Lorg/knp/bingeboard/data/model/TvMazeSearchResult;", "query", "singleSearch", "app_debug"})
public abstract interface TvMazeApiService {
    
    /**
     * Search shows by name — returns scored results
     */
    @retrofit2.http.GET(value = "search/shows")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchShows(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<org.knp.bingeboard.data.model.TvMazeSearchResult>> $completion);
    
    /**
     * Get full show details by TVmaze ID (no embed — for detail page)
     */
    @retrofit2.http.GET(value = "shows/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getShowDetails(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.knp.bingeboard.data.model.TvMazeShow> $completion);
    
    /**
     * Get show details with next/previous episode embedded (for watchlist)
     */
    @retrofit2.http.GET(value = "shows/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getShowDetailsWithEpisodes(@retrofit2.http.Path(value = "id")
    int id, @retrofit2.http.Query(value = "embed[]")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> embed, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.knp.bingeboard.data.model.TvMazeShow> $completion);
    
    /**
     * Lookup a show by IMDb ID
     */
    @retrofit2.http.GET(value = "lookup/shows")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object lookupByImdb(@retrofit2.http.Query(value = "imdb")
    @org.jetbrains.annotations.NotNull()
    java.lang.String imdbId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.knp.bingeboard.data.model.TvMazeShow> $completion);
    
    /**
     * Search by name — returns single best match
     */
    @retrofit2.http.GET(value = "singlesearch/shows")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object singleSearch(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.knp.bingeboard.data.model.TvMazeShow> $completion);
    
    /**
     * Get TV schedule for a specific date and country
     */
    @retrofit2.http.GET(value = "schedule/web")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWebSchedule(@retrofit2.http.Query(value = "date")
    @org.jetbrains.annotations.NotNull()
    java.lang.String date, @retrofit2.http.Query(value = "country")
    @org.jetbrains.annotations.Nullable()
    java.lang.String countryCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<org.knp.bingeboard.data.model.TvMazeEpisode>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}