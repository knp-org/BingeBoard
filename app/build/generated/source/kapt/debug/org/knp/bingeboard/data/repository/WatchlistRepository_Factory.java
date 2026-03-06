package org.knp.bingeboard.data.repository;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class WatchlistRepository_Factory implements Factory<WatchlistRepository> {
  private final Provider<Context> contextProvider;

  private final Provider<Moshi> moshiProvider;

  public WatchlistRepository_Factory(Provider<Context> contextProvider,
      Provider<Moshi> moshiProvider) {
    this.contextProvider = contextProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public WatchlistRepository get() {
    return newInstance(contextProvider.get(), moshiProvider.get());
  }

  public static WatchlistRepository_Factory create(Provider<Context> contextProvider,
      Provider<Moshi> moshiProvider) {
    return new WatchlistRepository_Factory(contextProvider, moshiProvider);
  }

  public static WatchlistRepository newInstance(Context context, Moshi moshi) {
    return new WatchlistRepository(context, moshi);
  }
}
