package com.example.app.view;

import com.example.app.domain.Customer;
import com.example.app.service.CustomerService;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

public class CustomerActivity {

    private final CustomerService service;

    @Inject
    public CustomerActivity(
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
