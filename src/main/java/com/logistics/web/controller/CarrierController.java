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

//    @GetMapping("/carriers")
//    public String listCarriers(Model model){
//        return "yo";
//    }
}
