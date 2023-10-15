package com.logistics.web.controller;

import com.logistics.web.models.Customer;
import com.logistics.web.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController  {

    public CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    public CustomerController() {}


    @GetMapping("/customer/new")
    public String createCustomerForm(Model model){
        Customer newcustomer = new Customer();
        model.addAttribute("customer",newcustomer);
        return "created customer";
    }

    @PostMapping("/customer/new")
    public String createNewCustomer(@ModelAttribute("customer") Customer customer ){
        customerService.createCustomer(customer);
        return "redirect:/";
    }


}
