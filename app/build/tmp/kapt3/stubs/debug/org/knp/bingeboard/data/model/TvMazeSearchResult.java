package org.knp.bingeboard.data.model;

import com.squareup.moshi.Json;

/**
 * Wrapper for TVmaze search results: /search/shows?q=...
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lorg/knp/bingeboard/data/model/TvMazeSearchResult;", "", "score", "", "show", "Lorg/knp/bingeboard/data/model/TvMazeShow;", "(DLorg/knp/bingeboard/data/model/TvMazeShow;)V", "getScore", "()D", "getShow", "()Lorg/knp/bingeboard/data/model/TvMazeShow;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class TvMazeSearchResult {
    private final double score = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.model.TvMazeShow show = null;
    
    public TvMazeSearchResult(@com.squareup.moshi.Json(name = "score")
    double score, @com.squareup.moshi.Json(name = "show")
    @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.model.TvMazeShow show) {
        super();
    }
    
    public final double getScore() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.model.TvMazeShow getShow() {
        return null;
    }
    
    public final double component1() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.model.TvMazeShow component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.model.TvMazeSearchResult copy(@com.squareup.moshi.Json(name = "score")
    double score, @com.squareup.moshi.Json(name = "show")
    @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.model.TvMazeShow show) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}