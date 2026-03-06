package org.knp.bingeboard.ui.screens.tv;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import org.knp.bingeboard.data.model.TvMazeEpisode;
import org.knp.bingeboard.data.repository.TvMazeRepository;
import org.knp.bingeboard.data.repository.UserPreferencesRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lorg/knp/bingeboard/ui/screens/tv/TvViewModel;", "Landroidx/lifecycle/ViewModel;", "tvMazeRepository", "Lorg/knp/bingeboard/data/repository/TvMazeRepository;", "userPreferencesRepository", "Lorg/knp/bingeboard/data/repository/UserPreferencesRepository;", "(Lorg/knp/bingeboard/data/repository/TvMazeRepository;Lorg/knp/bingeboard/data/repository/UserPreferencesRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/knp/bingeboard/ui/screens/tv/TvUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadSchedule", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TvViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.TvMazeRepository tvMazeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.UserPreferencesRepository userPreferencesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<org.knp.bingeboard.ui.screens.tv.TvUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.ui.screens.tv.TvUiState> uiState = null;
    
    @javax.inject.Inject()
    public TvViewModel(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.TvMazeRepository tvMazeRepository, @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.UserPreferencesRepository userPreferencesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.ui.screens.tv.TvUiState> getUiState() {
        return null;
    }
    
    public final void loadSchedule() {
    }
}