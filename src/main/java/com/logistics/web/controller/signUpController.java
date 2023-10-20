package com.logistics.web.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.logistics.web.dao.CustomerDao;
import com.logistics.web.models.Customer;
import com.logistics.web.services.CustomerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Controller
public class signUpController {

    @Autowired
    private CustomerService customerService;

    
    @GetMapping("/signUp")
    public String showsignUp(Model model){
        Customer customer = new Customer(); // Create a new Customer object
        model.addAttribute("customer", customer);
        return "signUp"; 
    }
    

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute Customer customer,Model model){
       Period age=Period.between((customer.getDateOfBirth()).toLocalDate(),LocalDate.now());
       int a=age.getYears();
       customer.setAge(a); 
      int customerID= customerService.handleAddCustomer(customer);
      System.out.println(customerID);
        model.addAttribute("CustomerID",customerID);
        return "logIn"; 

    }



    
   
}