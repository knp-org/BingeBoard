package org.knp.bingeboard.data.model;

import com.squareup.moshi.Json;

/**
 * Full TVmaze show object.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00f3\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0002\u0010\u001fJ\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0019H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010J\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00fc\u0001\u0010S\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00c6\u0001\u00a2\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010X\u001a\u00020\u0003H\u00d6\u0001J\t\u0010Y\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b7\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00102R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010,\u00a8\u0006Z"}, d2 = {"Lorg/knp/bingeboard/data/model/TvMazeShow;", "", "id", "", "name", "", "type", "language", "genres", "", "status", "runtime", "averageRuntime", "premiered", "ended", "officialSite", "schedule", "Lorg/knp/bingeboard/data/model/TvMazeSchedule;", "rating", "Lorg/knp/bingeboard/data/model/TvMazeRating;", "weight", "network", "Lorg/knp/bingeboard/data/model/TvMazeNetwork;", "webChannel", "externals", "Lorg/knp/bingeboard/data/model/TvMazeExternals;", "image", "Lorg/knp/bingeboard/data/model/TvMazeImage;", "summary", "embedded", "Lorg/knp/bingeboard/data/model/TvMazeEmbedded;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/knp/bingeboard/data/model/TvMazeSchedule;Lorg/knp/bingeboard/data/model/TvMazeRating;ILorg/knp/bingeboard/data/model/TvMazeNetwork;Lorg/knp/bingeboard/data/model/TvMazeNetwork;Lorg/knp/bingeboard/data/model/TvMazeExternals;Lorg/knp/bingeboard/data/model/TvMazeImage;Ljava/lang/String;Lorg/knp/bingeboard/data/model/TvMazeEmbedded;)V", "getAverageRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEmbedded", "()Lorg/knp/bingeboard/data/model/TvMazeEmbedded;", "getEnded", "()Ljava/lang/String;", "getExternals", "()Lorg/knp/bingeboard/data/model/TvMazeExternals;", "getGenres", "()Ljava/util/List;", "getId", "()I", "getImage", "()Lorg/knp/bingeboard/data/model/TvMazeImage;", "getLanguage", "getName", "getNetwork", "()Lorg/knp/bingeboard/data/model/TvMazeNetwork;", "getOfficialSite", "getPremiered", "getRating", "()Lorg/knp/bingeboard/data/model/TvMazeRating;", "getRuntime", "getSchedule", "()Lorg/knp/bingeboard/data/model/TvMazeSchedule;", "getStatus", "getSummary", "getType", "getWebChannel", "getWeight", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/knp/bingeboard/data/model/TvMazeSchedule;Lorg/knp/bingeboard/data/model/TvMazeRating;ILorg/knp/bingeboard/data/model/TvMazeNetwork;Lorg/knp/bingeboard/data/model/TvMazeNetwork;Lorg/knp/bingeboard/data/model/TvMazeExternals;Lorg/knp/bingeboard/data/model/TvMazeImage;Ljava/lang/String;Lorg/knp/bingeboard/data/model/TvMazeEmbedded;)Lorg/knp/bingeboard/data/model/TvMazeShow;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class TvMazeShow {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String type = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String language = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> genres = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer runtime = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer averageRuntime = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String premiered = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String ended = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String officialSite = null;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeSchedule schedule = null;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeRating rating = null;
    private final int weight = 0;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeNetwork network = null;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeNetwork webChannel = null;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeExternals externals = null;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeImage image = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String summary = null;
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeEmbedded embedded = null;
    
    public TvMazeShow(@com.squareup.moshi.Json(name = "id")
    int id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @com.squareup.moshi.Json(name = "type")
    @org.jetbrains.annotations.Nullable()
    java.lang.String type, @com.squareup.moshi.Json(name = "language")
    @org.jetbrains.annotations.Nullable()
    java.lang.String language, @com.squareup.moshi.Json(name = "genres")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, @com.squareup.moshi.Json(name = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.String status, @com.squareup.moshi.Json(name = "runtime")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer runtime, @com.squareup.moshi.Json(name = "averageRuntime")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer averageRuntime, @com.squareup.moshi.Json(name = "premiered")
    @org.jetbrains.annotations.Nullable()
    java.lang.String premiered, @com.squareup.moshi.Json(name = "ended")
    @org.jetbrains.annotations.Nullable()
    java.lang.String ended, @com.squareup.moshi.Json(name = "officialSite")
    @org.jetbrains.annotations.Nullable()
    java.lang.String officialSite, @com.squareup.moshi.Json(name = "schedule")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeSchedule schedule, @com.squareup.moshi.Json(name = "rating")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeRating rating, @com.squareup.moshi.Json(name = "weight")
    int weight, @com.squareup.moshi.Json(name = "network")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeNetwork network, @com.squareup.moshi.Json(name = "webChannel")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeNetwork webChannel, @com.squareup.moshi.Json(name = "externals")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeExternals externals, @com.squareup.moshi.Json(name = "image")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeImage image, @com.squareup.moshi.Json(name = "summary")
    @org.jetbrains.annotations.Nullable()
    java.lang.String summary, @com.squareup.moshi.Json(name = "_embedded")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeEmbedded embedded) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRuntime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAverageRuntime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPremiered() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEnded() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOfficialSite() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeSchedule getSchedule() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeRating getRating() {
        return null;
    }
    
    public final int getWeight() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeNetwork getNetwork() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeNetwork getWebChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeExternals getExternals() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeImage getImage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeEmbedded getEmbedded() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeSchedule component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeRating component13() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeNetwork component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeNetwork component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeExternals component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeImage component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeEmbedded component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.model.TvMazeShow copy(@com.squareup.moshi.Json(name = "id")
    int id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @com.squareup.moshi.Json(name = "type")
    @org.jetbrains.annotations.Nullable()
    java.lang.String type, @com.squareup.moshi.Json(name = "language")
    @org.jetbrains.annotations.Nullable()
    java.lang.String language, @com.squareup.moshi.Json(name = "genres")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, @com.squareup.moshi.Json(name = "status")
    @org.jetbrains.annotations.Nullable()
    java.lang.String status, @com.squareup.moshi.Json(name = "runtime")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer runtime, @com.squareup.moshi.Json(name = "averageRuntime")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer averageRuntime, @com.squareup.moshi.Json(name = "premiered")
    @org.jetbrains.annotations.Nullable()
    java.lang.String premiered, @com.squareup.moshi.Json(name = "ended")
    @org.jetbrains.annotations.Nullable()
    java.lang.String ended, @com.squareup.moshi.Json(name = "officialSite")
    @org.jetbrains.annotations.Nullable()
    java.lang.String officialSite, @com.squareup.moshi.Json(name = "schedule")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeSchedule schedule, @com.squareup.moshi.Json(name = "rating")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeRating rating, @com.squareup.moshi.Json(name = "weight")
    int weight, @com.squareup.moshi.Json(name = "network")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeNetwork network, @com.squareup.moshi.Json(name = "webChannel")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeNetwork webChannel, @com.squareup.moshi.Json(name = "externals")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeExternals externals, @com.squareup.moshi.Json(name = "image")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeImage image, @com.squareup.moshi.Json(name = "summary")
    @org.jetbrains.annotations.Nullable()
    java.lang.String summary, @com.squareup.moshi.Json(name = "_embedded")
    @org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeEmbedded embedded) {
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