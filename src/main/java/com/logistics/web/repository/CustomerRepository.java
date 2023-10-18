package com.logistics.web.repository;

import com.logistics.web.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer addCustomer(Customer customer){
        jdbcTemplate.update("INSERT INTO Customer(firstName,lastName,age,address,dateOfBirth,phone) VALUES(?,?,?,?,?,?)",customer.getFirstName(),customer.getLastName(),customer.getAge(),customer.getAddress(),customer.getDateOfBirth(),customer.getPhone());
        return customer;
    }

    public Customer getCustomerById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Customer WHERE customerId=?",id)
    }
}