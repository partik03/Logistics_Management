// package com.logistics.web.services.impl;

// import com.logistics.web.models.Customer;
// import com.logistics.web.repository.CustomerRepository;
// import com.logistics.web.services.CustomerService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CustomerServiceimpl implements CustomerService {


//     public CustomerRepository customerRepository;
//     @Autowired
//     public CustomerServiceimpl(CustomerRepository customerRepository){
//         this.customerRepository = customerRepository;
//     }

//     @Override
//     public List<Customer> findAllCustomers() {
//         List<Customer> customers = customerRepository.findAll();
//         return customers;
// //        return customers.stream().map(customer -> mapToCustomer(customer))
//     }

//     @Override
//     public Customer createCustomer(Customer customer){
//         return customerRepository.save(customer);
//     }
// }
