package com.logistics.web.services;

import com.logistics.web.models.User;

import java.util.List;

public interface AuthenticationService {
    public int handleAddCustomer(User user);
    public int handleAddAdmin(User user);
    public int handleAddEmployee(User user);
    public User handleGetUserById(int id);
    public User handleGetUserByUsername(String username);
    public int handleGetUserIdByUsername(String username);
    public List<User> handleGetAllCustomers();
    public List<User> handleGetAllEmployees();
    public List<User> handleGetAllAdminsByAuthority(String authority);
    public int handleDeleteUserById(int id);
    public int handleUpdateUserById(User user, int id);
    public int handleUpdateCustomerById(User user, int id);
}
