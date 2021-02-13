package com.enigmacamp.repository;

import com.enigmacamp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void add(Customer customer) {

    }

    @Override
    public Customer findById(String id) {
        List<Customer> customerList = jdbcTemplate.query("SELECT * FROM m_customer where id=?", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(resultSet.getString(1));
                customer.setFirstName(resultSet.getString(2));
                customer.setLastName(resultSet.getString(3));
                customer.setAddress(resultSet.getString(4));
                customer.setCity(resultSet.getString(5));
                return customer;
            }
        }, new Object[]{id});
        return customerList.get(0);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = jdbcTemplate.query("SELECT * FROM m_customer", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(resultSet.getString(1));
                customer.setFirstName(resultSet.getString(2));
                customer.setLastName(resultSet.getString(3));
                customer.setAddress(resultSet.getString(4));
                customer.setCity(resultSet.getString(5));
                return customer;
            }
        });
        return customerList;
    }

    @Override
    public Integer count() {
        Integer customerCount = jdbcTemplate.queryForObject("SELECT count(id) FROM m_customer", Integer.class);
        return customerCount;
    }
}
