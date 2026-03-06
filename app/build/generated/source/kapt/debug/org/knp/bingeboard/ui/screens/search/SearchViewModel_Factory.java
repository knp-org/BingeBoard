package org.knp.bingeboard.ui.screens.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.repository.TvMazeRepository;

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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<TvMazeRepository> tvMazeRepositoryProvider;

  public SearchViewModel_Factory(Provider<TvMazeRepository> tvMazeRepositoryProvider) {
    this.tvMazeRepositoryProvider = tvMazeRepositoryProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(tvMazeRepositoryProvider.get());
  }

  public static SearchViewModel_Factory create(
      Provider<TvMazeRepository> tvMazeRepositoryProvider) {
    return new SearchViewModel_Factory(tvMazeRepositoryProvider);
  }

  public static SearchViewModel newInstance(TvMazeRepository tvMazeRepository) {
    return new SearchViewModel(tvMazeRepository);
  }
}
