package customers;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Singleton
@Component(modules = {TestFactory.AppModule.class})
public interface TestFactory {
    CustomerEndpoint endpoint();

    @Module
    class AppModule {

        @Provides
        @Singleton
        Cache cache() {
            return new MockCache();
        }

        @Provides
        @Singleton
        Repository repository() {
            return new MockRepository();
        }
    }
}
