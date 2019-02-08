package com.example.app.service;

import com.example.app.cache.CustomerCache;
import com.example.app.domain.Customer;
import com.example.app.repository.CustomerRepository;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerCache cache;

    @Inject
    public CustomerService(
            final CustomerRepository repository,
            final CustomerCache cache) {
        this.repository = repository;
        this.cache = cache;
    }

    public void create(
            final Customer customer) {
        this.repository.saveToDb(customer);
        this.cache.saveToCache(customer);
    }

    public Optional<Customer> find(
            final UUID id) {
        final Optional<Customer> cachedCustomer = this.cache.getFromCache(id);
        if (cachedCustomer.isPresent()) {
            return cachedCustomer;
        } else {
            final Optional<Customer> dbCustomer = this.repository.getFromDb(id);
            if (dbCustomer.isPresent()) {
                this.cache.saveToCache(dbCustomer.get());
                return dbCustomer;
            }
        }
        return Optional.empty();
    }
}
