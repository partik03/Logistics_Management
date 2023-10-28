package com.logistics.web.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.logistics.web.dao.UserDao;
import com.logistics.web.models.User;
import com.logistics.web.services.AuthenticationService;
import com.logistics.web.services.UserService;


@Controller
public class loginController {
    

    @Autowired
    public AuthenticationService authenticationdao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println(name);
        
        if(name!="anonymousUser"){
            return "redirect:/user/orders";
        }
        User user =new User();
        model.addAttribute("user", user);
        return "logIn";
    }
    @PostMapping("/login")
    public String loginCheck(@ModelAttribute User user, Model model){
       User u= authenticationdao.handleGetUserByUsername(user.getUsername());
       System.out.println("hellllo");
       return "redirect:/user/orders";
    }
    @PostMapping("/login_failure_handler")
    public String loginCheck(){
        System.out.println("hellllo2");
        return "redirect:/login";
    }
    @PostMapping("/login_success_handler")
    public String loginCheck2(Model model){
        System.out.println("hellllo3");

        return "redirect:/user/orders"; 
    }
    @GetMapping("/signUp")
    public String signUp(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "signUp";
    }
    @PostMapping("/signUp")
    public String addCustomer(@ModelAttribute User user,Model model){
        
        Period age=Period.between((user.getDateOfBirth()).toLocalDate(),LocalDate.now());
        int a=age.getYears();
        user.setAge(a); 
       
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user);
        
        authenticationdao.handleAddCustomer(user);
        
        return "logIn";
        
    }
    @GetMapping("/logout")
    public void logout(){
        // System.out.println("THANKYOU for LOGGING IN");
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
