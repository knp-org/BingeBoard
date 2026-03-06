package org.knp.bingeboard.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.api.TvMazeApiService;

@ScopeMetadata("javax.inject.Singleton")
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
public final class TvMazeRepository_Factory implements Factory<TvMazeRepository> {
  private final Provider<TvMazeApiService> apiServiceProvider;

  public TvMazeRepository_Factory(Provider<TvMazeApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public TvMazeRepository get() {
    return newInstance(apiServiceProvider.get());
  }

  public static TvMazeRepository_Factory create(Provider<TvMazeApiService> apiServiceProvider) {
    return new TvMazeRepository_Factory(apiServiceProvider);
  }

  public static TvMazeRepository newInstance(TvMazeApiService apiService) {
    return new TvMazeRepository(apiService);
  }
}
