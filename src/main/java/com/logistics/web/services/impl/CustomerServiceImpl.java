 package com.logistics.web.services.impl;

 import com.logistics.web.dao.CustomerDao;
 import com.logistics.web.models.Customer;
 import com.logistics.web.services.CustomerService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 @Service
 public class CustomerServiceImpl implements CustomerService {


     public CustomerDao customerDao;
     @Autowired
     public CustomerServiceImpl(CustomerDao customerDao){
         this.customerDao = customerDao;
     }

     public Customer handleGetCustomerById(int id){
         return customerDao.getCustomerById(id);
     }

     public List<Customer> handleGetAllCustomers(){
         return customerDao.getAllCustomers();
     }

     public int handleAddCustomer(Customer customer){
         return customerDao.addCustomer(customer);
     }

     public int handleUpdateCustomerById(Customer customer,int customerId){
         return customerDao.updateCustomerById(customer,customerId);
     }

     public int handleDeleteCustomerById(int customerId){
         return customerDao.deleteCustomerById(customerId);
     }
 }
