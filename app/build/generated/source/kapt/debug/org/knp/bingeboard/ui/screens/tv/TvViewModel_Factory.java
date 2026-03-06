package org.knp.bingeboard.ui.screens.tv;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.repository.TvMazeRepository;
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
public final class TvViewModel_Factory implements Factory<TvViewModel> {
  private final Provider<TvMazeRepository> tvMazeRepositoryProvider;

  private final Provider<UserPreferencesRepository> userPreferencesRepositoryProvider;

  public TvViewModel_Factory(Provider<TvMazeRepository> tvMazeRepositoryProvider,
      Provider<UserPreferencesRepository> userPreferencesRepositoryProvider) {
    this.tvMazeRepositoryProvider = tvMazeRepositoryProvider;
    this.userPreferencesRepositoryProvider = userPreferencesRepositoryProvider;
  }

  @Override
  public TvViewModel get() {
    return newInstance(tvMazeRepositoryProvider.get(), userPreferencesRepositoryProvider.get());
  }

  public static TvViewModel_Factory create(Provider<TvMazeRepository> tvMazeRepositoryProvider,
      Provider<UserPreferencesRepository> userPreferencesRepositoryProvider) {
    return new TvViewModel_Factory(tvMazeRepositoryProvider, userPreferencesRepositoryProvider);
  }

  public static TvViewModel newInstance(TvMazeRepository tvMazeRepository,
      UserPreferencesRepository userPreferencesRepository) {
    return new TvViewModel(tvMazeRepository, userPreferencesRepository);
  }
}
