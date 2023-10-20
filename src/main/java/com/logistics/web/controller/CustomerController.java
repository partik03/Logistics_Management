package com.logistics.web.controller;

import com.logistics.web.dao.CustomerDao;
import com.logistics.web.models.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @PostMapping(
    path = "/customer/create",
    consumes = {org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String addCustomer(@ModelAttribute Customer customer,Model model){
        System.out.println(customer);
        model.addAttribute("customer", customer);
        return "logIn";
        // return customerDao.addCustomer(customer);
    }

    @GetMapping("/customer")
    // @ResponseBody
    public String getAllCustomers(Model model) {
    List<Customer> customers = customerDao.getAllCustomers();
    model.addAttribute("customers", new Customer());
    // System.out.println(customers);
    return "dashboard_customers";
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
    public int updateCustomerById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody Customer customer){
        return customerDao.updateCustomerById(customer, id);
    }
}
