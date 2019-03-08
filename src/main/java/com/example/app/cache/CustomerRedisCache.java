package com.example.app.cache;

import com.example.app.domain.Customer;

import java.util.Optional;
import java.util.UUID;

public class CustomerRedisCache implements CustomerCache {
    @Override
    public void saveToCache(Customer customer) {
        System.out.println("SAVED TO REDIS");
    }

    @Override
    public Optional<Customer> getFromCache(UUID id) {
        System.out.println("RETRIEVED FROM REDIS");
        return Optional.empty();
    }

    @Override
    public void method1() {

    }

    @Override
    public String method2() {
        return null;
    }
}
