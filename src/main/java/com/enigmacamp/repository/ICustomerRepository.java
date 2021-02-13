package com.enigmacamp.repository;

import com.enigmacamp.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    void add(Customer customer);

    Customer findById(String id);

    List<Customer> findAll();

    Integer count();
}
