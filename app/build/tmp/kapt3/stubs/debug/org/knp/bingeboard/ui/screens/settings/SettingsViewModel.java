package org.knp.bingeboard.ui.screens.settings;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.knp.bingeboard.data.repository.LocaleOptionsProvider;
import org.knp.bingeboard.data.repository.ThemeMode;
import org.knp.bingeboard.data.repository.UserPreferencesRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\tR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lorg/knp/bingeboard/ui/screens/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "preferencesRepository", "Lorg/knp/bingeboard/data/repository/UserPreferencesRepository;", "localeOptionsProvider", "Lorg/knp/bingeboard/data/repository/LocaleOptionsProvider;", "(Lorg/knp/bingeboard/data/repository/UserPreferencesRepository;Lorg/knp/bingeboard/data/repository/LocaleOptionsProvider;)V", "language", "Lkotlinx/coroutines/flow/StateFlow;", "", "getLanguage", "()Lkotlinx/coroutines/flow/StateFlow;", "getLocaleOptionsProvider", "()Lorg/knp/bingeboard/data/repository/LocaleOptionsProvider;", "region", "getRegion", "themeMode", "Lorg/knp/bingeboard/data/repository/ThemeMode;", "getThemeMode", "timezone", "getTimezone", "updateLanguage", "", "updateRegion", "updateThemeMode", "mode", "updateTimezone", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.UserPreferencesRepository preferencesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final org.knp.bingeboard.data.repository.LocaleOptionsProvider localeOptionsProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.data.repository.ThemeMode> themeMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> region = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> language = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> timezone = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.UserPreferencesRepository preferencesRepository, @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.LocaleOptionsProvider localeOptionsProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.knp.bingeboard.data.repository.LocaleOptionsProvider getLocaleOptionsProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<org.knp.bingeboard.data.repository.ThemeMode> getThemeMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getRegion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getTimezone() {
        return null;
    }
    
    public final void updateThemeMode(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.data.repository.ThemeMode mode) {
    }
    
    public final void updateRegion(@org.jetbrains.annotations.NotNull()
    java.lang.String region) {
    }
    
    public final void updateLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String language) {
    }
    
    public final void updateTimezone(@org.jetbrains.annotations.NotNull()
    java.lang.String timezone) {
    }
}