package com.logistics.web.repository;

import com.logistics.web.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

//    List<Customer> findAll;

}