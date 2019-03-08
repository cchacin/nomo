package customers;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Singleton
@Component(modules = {CustomerAppFactory.AppModule.class})
public interface CustomerAppFactory {
    CustomerEndpoint endpoint();

    @Module
    class AppModule {

        @Provides
        @Singleton
        Cache cache() {
            return new FileSystemCache();
        }

        @Provides
        @Singleton
        Repository repository() {
            return new DbRepository();
        }
    }
}
