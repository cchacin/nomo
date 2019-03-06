package com.example.app;

import com.example.app.cache.CustomerCache;
import com.example.app.cache.FileSystemCache;
import com.example.app.repository.CustomerRepository;
import com.example.app.repository.DbRepository;
import com.example.app.view.CustomerController;
import dagger.Component;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Singleton
@Component(modules = { AppFactory.AppModule.class })
public interface AppFactory {
    CustomerController controller();

    @Module
    class AppModule {
    
        @Provides
        @Singleton
        CustomerCache cache() {
            return new FileSystemCache();
        }
    
        @Provides
        @Singleton
        CustomerRepository repository() {
            return new DbRepository();
        }
    }
}
