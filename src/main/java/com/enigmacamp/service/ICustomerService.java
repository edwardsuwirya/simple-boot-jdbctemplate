package com.enigmacamp.service;

import com.enigmacamp.entity.Customer;

import java.util.List;

public interface ICustomerService {
    void createNewCustomer(Customer customer);

    Customer getCustomerById(String id);

    List<Customer> getAllCustomer();

    Integer getTotalCustomer();
}
