package org.knp.bingeboard.ui.screens.detail;

import androidx.lifecycle.SavedStateHandle;
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
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<TvMazeRepository> tvMazeRepositoryProvider;

  private final Provider<WatchlistRepository> watchlistRepositoryProvider;

  public DetailViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<TvMazeRepository> tvMazeRepositoryProvider,
      Provider<WatchlistRepository> watchlistRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.tvMazeRepositoryProvider = tvMazeRepositoryProvider;
    this.watchlistRepositoryProvider = watchlistRepositoryProvider;
  }

  @Override
  public DetailViewModel get() {
    return newInstance(savedStateHandleProvider.get(), tvMazeRepositoryProvider.get(), watchlistRepositoryProvider.get());
  }

  public static DetailViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<TvMazeRepository> tvMazeRepositoryProvider,
      Provider<WatchlistRepository> watchlistRepositoryProvider) {
    return new DetailViewModel_Factory(savedStateHandleProvider, tvMazeRepositoryProvider, watchlistRepositoryProvider);
  }

  public static DetailViewModel newInstance(SavedStateHandle savedStateHandle,
      TvMazeRepository tvMazeRepository, WatchlistRepository watchlistRepository) {
    return new DetailViewModel(savedStateHandle, tvMazeRepository, watchlistRepository);
  }
}
