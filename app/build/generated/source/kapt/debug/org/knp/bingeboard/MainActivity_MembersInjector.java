package org.knp.bingeboard;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.knp.bingeboard.data.repository.UserPreferencesRepository;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<UserPreferencesRepository> preferencesRepositoryProvider;

  public MainActivity_MembersInjector(
      Provider<UserPreferencesRepository> preferencesRepositoryProvider) {
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<UserPreferencesRepository> preferencesRepositoryProvider) {
    return new MainActivity_MembersInjector(preferencesRepositoryProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectPreferencesRepository(instance, preferencesRepositoryProvider.get());
  }

  @InjectedFieldSignature("org.knp.bingeboard.MainActivity.preferencesRepository")
  public static void injectPreferencesRepository(MainActivity instance,
      UserPreferencesRepository preferencesRepository) {
    instance.preferencesRepository = preferencesRepository;
  }
}
