package com.example.app;

import com.example.app.cache.CustomerCache;
import com.example.app.cache.FileSystemCache;
import com.example.app.repository.CustomerRepository;
import com.example.app.repository.DbRepository;
import com.example.app.view.CustomerController;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.UUID;

public class App {
    
    @Produces
    CustomerCache cache() {
        return new FileSystemCache();
    }
    
    @Produces
    CustomerRepository repository() {
        return new DbRepository();
    }

    public static void main(String[] args) {

        try (final SeContainer container = SeContainerInitializer.newInstance()
                .disableDiscovery()
                .addPackages(true, App.class)
                .initialize()) {
            final CustomerController controller =
                    container.select(CustomerController.class)
                            .get();

            System.out.println(controller.find(UUID.randomUUID()));
        }
    }
}
