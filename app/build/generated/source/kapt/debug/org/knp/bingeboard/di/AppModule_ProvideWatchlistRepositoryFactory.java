package org.knp.bingeboard.di;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.repository.WatchlistRepository;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideWatchlistRepositoryFactory implements Factory<WatchlistRepository> {
  private final Provider<Context> contextProvider;

  private final Provider<Moshi> moshiProvider;

  public AppModule_ProvideWatchlistRepositoryFactory(Provider<Context> contextProvider,
      Provider<Moshi> moshiProvider) {
    this.contextProvider = contextProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public WatchlistRepository get() {
    return provideWatchlistRepository(contextProvider.get(), moshiProvider.get());
  }

  public static AppModule_ProvideWatchlistRepositoryFactory create(
      Provider<Context> contextProvider, Provider<Moshi> moshiProvider) {
    return new AppModule_ProvideWatchlistRepositoryFactory(contextProvider, moshiProvider);
  }

  public static WatchlistRepository provideWatchlistRepository(Context context, Moshi moshi) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideWatchlistRepository(context, moshi));
  }
}
