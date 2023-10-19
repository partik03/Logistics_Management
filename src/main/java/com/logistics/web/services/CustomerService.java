 package com.logistics.web.services;

 import com.logistics.web.models.Customer;

 import java.util.List;

 import org.springframework.stereotype.Service;

 public interface CustomerService {


     public Customer handleGetCustomerById(int id);

     public List<Customer> handleGetAllCustomers();

     public int handleAddCustomer(Customer customer);

     public int handleUpdateCustomerById(Customer customer,int customerId);

     public int handleDeleteCustomerById(int customerId);



 }
