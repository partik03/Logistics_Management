package com.logistics.web.controller;

import com.logistics.web.dao.CustomerDao;
import com.logistics.web.models.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @PostMapping("/customer")
    @ResponseBody
    public int addCustomer(@Valid @NotNull @RequestBody Customer customer){
        return customerDao.addCustomer(customer);
    }

    @GetMapping("/customer")
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomerById(@Valid @NotNull @PathVariable("id") int id){
        return customerDao.getCustomerById(id);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseBody
    public int deleteCustomerById(@Valid @NotNull @PathVariable("id") int id){
        return customerDao.deleteCustomerById(id);
    }

    @PutMapping("/customer/{id}")
    @ResponseBody
    public Customer updateCustomerById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody Customer customer){
        return customerDao.updateCustomerById(customer, id);
    }
}
