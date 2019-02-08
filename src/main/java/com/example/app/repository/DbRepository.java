package com.example.app.repository;

import com.example.app.domain.Customer;

import javax.enterprise.inject.Alternative;
import java.util.Optional;
import java.util.UUID;

@Alternative
public class DbRepository implements CustomerRepository {
    @Override
    public void saveToDb(Customer customer) {
        System.out.println("SAVED TO DATABASE");
    }

    @Override
    public Optional<Customer> getFromDb(UUID id) {
        System.out.println("RETRIVED FROM DATABASE");
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
