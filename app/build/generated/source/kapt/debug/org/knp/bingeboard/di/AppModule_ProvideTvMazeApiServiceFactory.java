package org.knp.bingeboard.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.api.TvMazeApiService;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class AppModule_ProvideTvMazeApiServiceFactory implements Factory<TvMazeApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideTvMazeApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public TvMazeApiService get() {
    return provideTvMazeApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideTvMazeApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideTvMazeApiServiceFactory(retrofitProvider);
  }

  public static TvMazeApiService provideTvMazeApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTvMazeApiService(retrofit));
  }
}
