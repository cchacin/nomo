package com.example.app.cache;

import com.example.app.domain.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerCache {

    void saveToCache(
            final Customer customer);

    Optional<Customer> getFromCache(
            final UUID id);

    void method1();

    String method2();

}
