package customers;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

@Singleton
@Component(modules = {CustomerAppFactory.AppModule.class})
public interface CustomerAppFactory {
    CustomerEndpoint endpoint();

    DbRepository dbRepository = new DbRepository();
    FileSystemCache fileSystemCache = new FileSystemCache();

    @Module
    class AppModule {

        @Provides
        @Singleton
        @Named("getFromCache")
        Function<UUID, Optional<Customer>> getFromCache() {
            return fileSystemCache::getFromCache;
        }

        @Provides
        @Singleton
        @Named("getFromDb")
        Function<UUID, Optional<Customer>> getFromRepository() {
            return dbRepository::getFromDb;
        }

        @Provides
        @Singleton
        @Named("saveToDb")
        Consumer<Customer> saveToDb() {
            return dbRepository::saveToDb;
        }

        @Provides
        @Singleton
        @Named("saveToCache")
        Consumer<Customer> saveToCache() {
            return fileSystemCache::saveToCache;
        }
    }
}
