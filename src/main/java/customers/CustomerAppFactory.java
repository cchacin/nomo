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
        CustomerCache cache() {
            return new CustomerFileSystemCache();
        }

        @Provides
        @Singleton
        CustomerRepository repository() {
            return new CustomerDbRepository();
        }
    }
}
