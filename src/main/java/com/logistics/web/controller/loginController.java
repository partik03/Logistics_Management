package com.logistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class loginController {
    
    @GetMapping("/dashboard")
    public String showDashboard(){
        return "dashboard"; 
    }
}
