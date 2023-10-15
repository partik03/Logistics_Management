package com.logistics.web.services;

import com.logistics.web.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer createCustomer(Customer customer);

}
