package com.logistics.web.controller;

import com.logistics.web.services.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarrierController {
    private CarrierService carrierService;
//    @Autowired
//    public CarrierController(CarrierService carrierService){
//        this.carrierService =  carrierService;
//    }
   @GetMapping
   public String home(Model model){
       return "index";
   }

   @GetMapping("/sign-up")
   public String signUp(Model model){
       return "signUp";
   }
   @GetMapping("/log-in")
   public String logIn(Model model){
       return "logIn";
   }

   @GetMapping("/order")
   public String bookOrder(Model model){
       return "bookOrder";
   }
    
//     @GetMapping("/")
//     public String
}
