package com.logistics.web.dao;

import com.logistics.web.models.Customer;
import com.logistics.web.rowMappers.CustomerRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addCustomer(Customer customer){
        String sql = "INSERT INTO Customer(password,firstName,lastName,age,address,dateOfBirth,phone) VALUES(?,?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getPassword());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setInt(4,customer.getAge());
            ps.setString(5,customer.getAddress());
            ps.setDate(6,customer.getDateOfBirth());
            ps.setString(7,customer.getPhone());
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public Customer getCustomerById(int id){

        String sql = "SELECT * FROM Customer WHERE customerId = ?";
        Customer customer = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Customer>(Customer.class),id);
        return customer;
    }
    

    public List<Customer> getAllCustomers(){
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
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