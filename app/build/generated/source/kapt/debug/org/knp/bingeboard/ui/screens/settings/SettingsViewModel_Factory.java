package org.knp.bingeboard.ui.screens.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.repository.LocaleOptionsProvider;
import org.knp.bingeboard.data.repository.UserPreferencesRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<UserPreferencesRepository> preferencesRepositoryProvider;

  private final Provider<LocaleOptionsProvider> localeOptionsProvider;

  public SettingsViewModel_Factory(
      Provider<UserPreferencesRepository> preferencesRepositoryProvider,
      Provider<LocaleOptionsProvider> localeOptionsProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.localeOptionsProvider = localeOptionsProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(preferencesRepositoryProvider.get(), localeOptionsProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<UserPreferencesRepository> preferencesRepositoryProvider,
      Provider<LocaleOptionsProvider> localeOptionsProvider) {
    return new SettingsViewModel_Factory(preferencesRepositoryProvider, localeOptionsProvider);
  }

  public static SettingsViewModel newInstance(UserPreferencesRepository preferencesRepository,
      LocaleOptionsProvider localeOptionsProvider) {
    return new SettingsViewModel(preferencesRepository, localeOptionsProvider);
  }
}
