package com.logistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class loginController {
    
    

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "logIn";
    }
    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }
    @GetMapping("/user/placeOrder")
    public String placeOrder(){
        return "placeOrder";
    }
    @GetMapping("/user/orders")
    public String getUserOrders(){
        return "user_orders";
    }
    @GetMapping("/user/complaints")
    public String getUserComplaints(){
        return "user_complaints";
    }
    @GetMapping("/user/invoices")
    public String getUserInvoices(){
        return "user_invoices";
    }
    @GetMapping("/user/placeComplaint")
    public String placeComplaint(){
        return "placeComplaint";
    }
    @GetMapping("/showWarehouse")
    public String warehouse(){
        return "warehouse";
    }
    @GetMapping("/showCarrier")
    public String carrier(){
        return "carrier";
    }




}
