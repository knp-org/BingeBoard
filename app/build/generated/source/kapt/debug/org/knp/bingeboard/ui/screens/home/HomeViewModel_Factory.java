package org.knp.bingeboard.ui.screens.home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.repository.TvMazeRepository;
import org.knp.bingeboard.data.repository.WatchlistRepository;

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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<WatchlistRepository> watchlistRepositoryProvider;

  private final Provider<TvMazeRepository> tvMazeRepositoryProvider;

  public HomeViewModel_Factory(Provider<WatchlistRepository> watchlistRepositoryProvider,
      Provider<TvMazeRepository> tvMazeRepositoryProvider) {
    this.watchlistRepositoryProvider = watchlistRepositoryProvider;
    this.tvMazeRepositoryProvider = tvMazeRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(watchlistRepositoryProvider.get(), tvMazeRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<WatchlistRepository> watchlistRepositoryProvider,
      Provider<TvMazeRepository> tvMazeRepositoryProvider) {
    return new HomeViewModel_Factory(watchlistRepositoryProvider, tvMazeRepositoryProvider);
  }

  public static HomeViewModel newInstance(WatchlistRepository watchlistRepository,
      TvMazeRepository tvMazeRepository) {
    return new HomeViewModel(watchlistRepository, tvMazeRepository);
  }
}
