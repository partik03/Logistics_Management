 package com.logistics.web.services;

 import com.logistics.web.models.Customer;

 import java.util.List;

 import org.springframework.stereotype.Service;

 public interface CustomerService {

     List<Customer> findAllCustomers();

     Customer createCustomer(Customer customer);

     Customer updateCustomer(Object data,int customerId);

     Boolean deleteCustomer(int customerId);

 }
