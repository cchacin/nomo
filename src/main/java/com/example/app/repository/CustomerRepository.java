package com.example.app.repository;

import com.example.app.domain.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    public void saveToDb(
            final Customer customer);

    public Optional<Customer> getFromDb(
            final UUID id);

    public void method1();

    public String method2();
}
