package com.enigmacamp.service;

import com.enigmacamp.entity.Customer;
import com.enigmacamp.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public void createNewCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Integer getTotalCustomer() {
        return customerRepository.count();
    }

    @Transactional
    @Override
    public void createBulkCustomer(List<Customer> customers) {
        for (Customer c : customers) {
            customerRepository.add(c);
        }
    }
}
