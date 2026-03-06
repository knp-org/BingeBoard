package org.knp.bingeboard.ui.screens.detail;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.time.LocalDate;
import org.knp.bingeboard.data.model.TvMazeShow;
import org.knp.bingeboard.data.repository.TvMazeRepository;
import org.knp.bingeboard.data.repository.WatchlistRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lorg/knp/bingeboard/ui/screens/detail/DetailUiState;", "", "tvMazeShow", "Lorg/knp/bingeboard/data/model/TvMazeShow;", "isLoading", "", "error", "", "isInWatchlist", "airTimeDisplay", "source", "(Lorg/knp/bingeboard/data/model/TvMazeShow;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAirTimeDisplay", "()Ljava/lang/String;", "getError", "()Z", "getSource", "getTvMazeShow", "()Lorg/knp/bingeboard/data/model/TvMazeShow;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class DetailUiState {
    @org.jetbrains.annotations.Nullable()
    private final org.knp.bingeboard.data.model.TvMazeShow tvMazeShow = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    private final boolean isInWatchlist = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String airTimeDisplay = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String source = null;
    
    public DetailUiState(@org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeShow tvMazeShow, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, boolean isInWatchlist, @org.jetbrains.annotations.Nullable()
    java.lang.String airTimeDisplay, @org.jetbrains.annotations.NotNull()
    java.lang.String source) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeShow getTvMazeShow() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public final boolean isInWatchlist() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAirTimeDisplay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSource() {
        return null;
    }
    
    public DetailUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.knp.bingeboard.data.model.TvMazeShow component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.ui.screens.detail.DetailUiState copy(@org.jetbrains.annotations.Nullable()
    org.knp.bingeboard.data.model.TvMazeShow tvMazeShow, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, boolean isInWatchlist, @org.jetbrains.annotations.Nullable()
    java.lang.String airTimeDisplay, @org.jetbrains.annotations.NotNull()
    java.lang.String source) {
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