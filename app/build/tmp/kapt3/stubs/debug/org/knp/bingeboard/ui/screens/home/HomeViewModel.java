package org.knp.bingeboard.ui.screens.home;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.time.LocalDate;
import org.knp.bingeboard.data.model.TvMazeShow;
import org.knp.bingeboard.data.model.WatchlistDisplayItem;
import org.knp.bingeboard.data.repository.TvMazeRepository;
import org.knp.bingeboard.data.repository.WatchlistRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0013J)\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002\u00a2\u0006\u0002\u0010\u001bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lorg/knp/bingeboard/ui/screens/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "watchlistRepository", "Lorg/knp/bingeboard/data/repository/WatchlistRepository;", "tvMazeRepository", "Lorg/knp/bingeboard/data/repository/TvMazeRepository;", "(Lorg/knp/bingeboard/data/repository/WatchlistRepository;Lorg/knp/bingeboard/data/repository/TvMazeRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/knp/bingeboard/ui/screens/home/HomeUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadWatchlist", "", "refreshWatchlist", "retry", "syncWatchlist", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDisplayItem", "Lorg/knp/bingeboard/data/model/WatchlistDisplayItem;", "Lorg/knp/bingeboard/data/model/TvMazeShow;", "airTimeDisplay", "", "airTimestamp", "", "(Lorg/knp/bingeboard/data/model/TvMazeShow;Ljava/lang/String;Ljava/lang/Long;)Lorg/knp/bingeboard/data/model/WatchlistDisplayItem;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.WatchlistRepository watchlistRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.TvMazeRepository tvMazeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<org.knp.bingeboard.ui.screens.home.HomeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.ui.screens.home.HomeUiState> uiState = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.WatchlistRepository watchlistRepository, @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.TvMazeRepository tvMazeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.ui.screens.home.HomeUiState> getUiState() {
        return null;
    }
    
    /**
     * Used for initial load triggers if needed by UI
     */
    public final void loadWatchlist() {
    }
    
    /**
     * Refresh the watchlist by making API calls for all items.
     * This is used for pull-to-refresh and for migrating legacy items.
     */
    public final void refreshWatchlist() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncWatchlist(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void retry() {
    }
    
    private final org.knp.bingeboard.data.model.WatchlistDisplayItem toDisplayItem(org.knp.bingeboard.data.model.TvMazeShow $this$toDisplayItem, java.lang.String airTimeDisplay, java.lang.Long airTimestamp) {
        return null;
    }
}