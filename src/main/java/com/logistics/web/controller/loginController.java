package com.logistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class loginController {
    
    

    @GetMapping("/logIn")
    public String login(){
        return "logIn";
    }


}
