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
public final class LocaleOptionsProvider_Factory implements Factory<LocaleOptionsProvider> {
  private final Provider<Context> contextProvider;

  private final Provider<Moshi> moshiProvider;

  public LocaleOptionsProvider_Factory(Provider<Context> contextProvider,
      Provider<Moshi> moshiProvider) {
    this.contextProvider = contextProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public LocaleOptionsProvider get() {
    return newInstance(contextProvider.get(), moshiProvider.get());
  }

  public static LocaleOptionsProvider_Factory create(Provider<Context> contextProvider,
      Provider<Moshi> moshiProvider) {
    return new LocaleOptionsProvider_Factory(contextProvider, moshiProvider);
  }

  public static LocaleOptionsProvider newInstance(Context context, Moshi moshi) {
    return new LocaleOptionsProvider(context, moshi);
  }
}
