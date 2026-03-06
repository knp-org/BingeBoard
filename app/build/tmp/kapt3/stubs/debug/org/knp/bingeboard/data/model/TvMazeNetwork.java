package org.knp.bingeboard.data.model;

import com.squareup.moshi.Json;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lorg/knp/bingeboard/data/model/TvMazeNetwork;", "", "id", "", "name", "", "country", "Lorg/knp/bingeboard/data/model/TvMazeCountry;", "officialSite", "(ILjava/lang/String;Lorg/knp/bingeboard/data/model/TvMazeCountry;Ljava/lang/String;)V", "getCountry", "()Lorg/knp/bingeboard/data/model/TvMazeCountry;", "getId", "()I", "getName", "()Ljava/lang/String;", "getOfficialSite", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class TvMazeNetwork {
    private final int id = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeCountry country = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String officialSite = null;
    
    public TvMazeNetwork(@com.squareup.moshi.Json(name = "id")
    int id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.Nullable()
    java.lang.String name, @com.squareup.moshi.Json(name = "country")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeCountry country, @com.squareup.moshi.Json(name = "officialSite")
    @org.jetbrains.annotations.Nullable()
    java.lang.String officialSite) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeCountry getCountry() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOfficialSite() {
        return null;
    }
    
    public TvMazeNetwork() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeCountry component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.model.TvMazeNetwork copy(@com.squareup.moshi.Json(name = "id")
    int id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.Nullable()
    java.lang.String name, @com.squareup.moshi.Json(name = "country")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeCountry country, @com.squareup.moshi.Json(name = "officialSite")
    @org.jetbrains.annotations.Nullable()
    java.lang.String officialSite) {
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