package com.logistics.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.logistics.web.dao.CustomerDao;
import com.logistics.web.models.Customer;

@Controller
public class CHECKER {
    @Autowired
    private  CustomerDao customerDao;
    @GetMapping("/check/{id}")
    public String testing(@PathVariable int id, Model model){
       
       
           Customer customer= customerDao.getCustomerById(id);
       
       

        // // Add the customer object to the model
        model.addAttribute("customer", customer);
        System.out.println(model);
        // Return a view to display the customer information
        return "customer-details";
       
    }
}
