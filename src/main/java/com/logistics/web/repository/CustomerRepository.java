package com.logistics.web.repository;

import com.logistics.web.models.Customer;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


@EnableJdbcRepositories("com.logistics.web.repository")
public interface CustomerRepository extends Repository<Customer,Long> {

    List<Customer> findAll();
    Customer save(Customer customer);

}
