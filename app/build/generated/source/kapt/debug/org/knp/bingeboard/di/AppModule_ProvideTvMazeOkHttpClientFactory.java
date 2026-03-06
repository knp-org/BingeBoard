package org.knp.bingeboard.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

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
public final class AppModule_ProvideTvMazeOkHttpClientFactory implements Factory<OkHttpClient> {
  @Override
  public OkHttpClient get() {
    return provideTvMazeOkHttpClient();
  }

  public static AppModule_ProvideTvMazeOkHttpClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OkHttpClient provideTvMazeOkHttpClient() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTvMazeOkHttpClient());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideTvMazeOkHttpClientFactory INSTANCE = new AppModule_ProvideTvMazeOkHttpClientFactory();
  }
}
