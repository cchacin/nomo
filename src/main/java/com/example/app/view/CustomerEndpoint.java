package com.example.app.view;

import com.example.app.domain.Customer;
import com.example.app.service.CustomerService;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

public class CustomerEndpoint {

    private final CustomerService service;

    @Inject
    public CustomerEndpoint(
            final CustomerService service) {
        this.service = service;
    }

    public void create(
            Customer customer) {
        service.create(customer);
    }

    public Optional<Customer> find(
            UUID id) {
        return service.find(id);
    }
}
