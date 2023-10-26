package com.logistics.web.services.impl;

import com.logistics.web.dao.AuthenticationDao;
import com.logistics.web.models.User;
import com.logistics.web.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    public AuthenticationDao authenticationDao;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationDao authenticationDao){
        this.authenticationDao = authenticationDao;
    }

    @Override
    public int handleAddCustomer(User user) {
        return authenticationDao.addCustomer(user);
    }

    @Override
    public int handleAddAdmin(User user) {
        return authenticationDao.addAdmin(user);
    }

    @Override
    public User handleGetUserById(int id) {
        return authenticationDao.getUserById(id);
    }

    @Override
    public User handleGetUserByUsername(String username) {
        return authenticationDao.getUserByUsername(username);
    }

    @Override
    public List<User> handleGetAllCustomers() {
        return authenticationDao.getAllCustomers();
    }

    @Override
    public List<User> handleGetAllAdminsByAuthority(String authority) {
        return authenticationDao.getAllAdminsByAuthority(authority);
    }

    @Override
    public int handleDeleteUserById(int id) {
        return authenticationDao.deleteUserById(id);
    }

    @Override
    public int handleUpdateUserById(User user, int id) {
        return authenticationDao.updateUserById(user,id);
    }
}
