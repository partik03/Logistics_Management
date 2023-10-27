package com.logistics.web.services;

import com.logistics.web.models.User;

import java.util.List;

public interface UserService {

    public List<User> handleGetAllUsers();

    public User handleGetUserById(int id);

    public int handleAddUser( User User );

    public int handleUpdateUserById(User User,int id);

    public int handleDeleteUserById(int id);


}
