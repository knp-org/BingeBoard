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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lorg/knp/bingeboard/ui/screens/detail/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "tvMazeRepository", "Lorg/knp/bingeboard/data/repository/TvMazeRepository;", "watchlistRepository", "Lorg/knp/bingeboard/data/repository/WatchlistRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lorg/knp/bingeboard/data/repository/TvMazeRepository;Lorg/knp/bingeboard/data/repository/WatchlistRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/knp/bingeboard/ui/screens/detail/DetailUiState;", "mediaId", "", "mediaType", "", "source", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadDetails", "", "retry", "toggleWatchlist", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.TvMazeRepository tvMazeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.WatchlistRepository watchlistRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<org.knp.bingeboard.ui.screens.detail.DetailUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.ui.screens.detail.DetailUiState> uiState = null;
    private final int mediaId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String mediaType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String source = null;
    
    @javax.inject.Inject()
    public DetailViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.TvMazeRepository tvMazeRepository, @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.WatchlistRepository watchlistRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.ui.screens.detail.DetailUiState> getUiState() {
        return null;
    }
    
    private final void loadDetails() {
    }
    
    public final void toggleWatchlist() {
    }
    
    public final void retry() {
    }
}