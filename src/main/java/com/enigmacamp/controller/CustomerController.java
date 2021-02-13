package com.enigmacamp.controller;

import com.enigmacamp.entity.Customer;
import com.enigmacamp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customerList = customerService.getAllCustomer();
        return new ResponseEntity(customerList, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getAllCustomer(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customer/bulk")
    public ResponseEntity createBulkCustomer() {
        List<Customer> customers = new ArrayList<>();
        Customer c1 = new Customer();
        c1.setId("123");
        c1.setFirstName("Egi");
        c1.setLastName("Joss");
        c1.setAddress("Ragunan");
        c1.setCity("Jakarta");

        Customer c2 = new Customer();
        c2.setId("234");
        c2.setFirstName("Arip");
        c2.setLastName("Komeng");
        c2.setAddress("Ragunan");
        c2.setCity("Jakarta");

        customers.add(c1);
        customers.add(c2);
        customerService.createBulkCustomer(customers);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
