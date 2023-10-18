package com.logistics.web.repository;

import com.logistics.web.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        String sql = "SELECT * FROM Customer WHERE customerId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer getAllCustomers(){
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.queryForObject(sql, new Object[] {}, new BeanPropertyRowMapper<>(Customer.class));
    }

    public int deleteCustomerById(int id){
        String sql = "DELETE FROM Customer WHERE customerId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public Customer updateCustomerById(Customer customer, int id){
        String sql = "UPDATE Customer SET password=?, firstName=?, lastName=?, age=?, address=?, dateOfBirth=?, phone=? WHERE customerId = ?";
        jdbcTemplate.update(sql,customer.getPassword(),customer.getFirstName(),customer.getLastName(),customer.getAge(),customer.getAddress(),customer.getDateOfBirth(),customer.getPhone(),id);
        return customer;
    }
}