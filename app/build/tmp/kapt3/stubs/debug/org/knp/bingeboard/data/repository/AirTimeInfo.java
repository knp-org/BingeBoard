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

/**
 * Holds the air-time info after timezone conversion.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lorg/knp/bingeboard/data/repository/AirTimeInfo;", "", "localTime", "", "days", "displayLabel", "userDateTime", "Ljava/time/ZonedDateTime;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/time/ZonedDateTime;)V", "getDays", "()Ljava/lang/String;", "getDisplayLabel", "getLocalTime", "getUserDateTime", "()Ljava/time/ZonedDateTime;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class AirTimeInfo {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String localTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String days = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String displayLabel = null;
    @org.jetbrains.annotations.Nullable()
    private final java.time.ZonedDateTime userDateTime = null;
    
    public AirTimeInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String localTime, @org.jetbrains.annotations.NotNull()
    java.lang.String days, @org.jetbrains.annotations.NotNull()
    java.lang.String displayLabel, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime userDateTime) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocalTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDays() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getUserDateTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.repository.AirTimeInfo copy(@org.jetbrains.annotations.NotNull()
    java.lang.String localTime, @org.jetbrains.annotations.NotNull()
    java.lang.String days, @org.jetbrains.annotations.NotNull()
    java.lang.String displayLabel, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime userDateTime) {
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