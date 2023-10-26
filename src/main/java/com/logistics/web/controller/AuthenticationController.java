package com.logistics.web.controller;

import com.logistics.web.models.User;
import com.logistics.web.services.impl.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthenticationController {

    public AuthenticationServiceImpl authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authenticationService){
        this.authenticationService = authenticationService;
    }
    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@Valid @NotNull @PathVariable("id") int id){
        return authenticationService.handleGetUserById(id);
    }

    @GetMapping("/username/{username}")
    @ResponseBody
    public User getUserByUsername(@Valid @NotNull @PathVariable("username") String username){
        return authenticationService.handleGetUserByUsername(username);
    }

    @GetMapping("/customer")
    @ResponseBody
    public List<User> getAllCustomers(){
        return authenticationService.handleGetAllCustomers();
    }

    @GetMapping("/employee")
    @ResponseBody
    public List<User> getAllEmployees(){
        return authenticationService.handleGetAllEmployees();
    }

    @GetMapping("/admin/{authority}")
    @ResponseBody
    public List<User> getAllAdminsByAuthority(@Valid @NotNull @PathVariable("authority") String authority){
        return authenticationService.handleGetAllAdminsByAuthority(authority);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public int deleteUserById(@Valid @NotNull @PathVariable("id") int id){
        return authenticationService.handleDeleteUserById(id);
    }
    @PutMapping("/user/{id}")
    @ResponseBody
    public int updateUserById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody User user){
        return authenticationService.handleUpdateUserById(user,id);
    }

    @PostMapping("/customer")
    @ResponseBody
    public int addCustomer(@Valid @NotNull @RequestBody User user){
        return authenticationService.handleAddCustomer(user);
    }
    @PostMapping("/admin")
    @ResponseBody
    public int addAdmin(@Valid @NotNull @RequestBody User user){
        return authenticationService.handleAddAdmin(user);
    }
}
