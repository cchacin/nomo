package customers;

import com.example.app.cache.CustomerCache;
import com.example.app.repository.CustomerRepository;
import com.example.app.view.CustomerEndpoint;
import dagger.Component;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Singleton
@Component(modules = { TestFactory.AppModule.class })
public interface TestFactory {
    CustomerEndpoint endpoint();

    @Module
    class AppModule {
    
        @Provides
        @Singleton
        CustomerCache cache() {
            return new MockCache();
        }
    
        @Provides
        @Singleton
        CustomerRepository repository() {
            return new MockRepository();
        }
    }
}
