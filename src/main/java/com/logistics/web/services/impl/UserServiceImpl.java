 package com.logistics.web.services.impl;

 import com.logistics.web.dao.UserDao;
 import com.logistics.web.models.User;
 import com.logistics.web.services.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import java.util.List;

 @Service
 public abstract class UserServiceImpl implements UserService {

    @Autowired
     public UserDao userDao;

     
     public UserServiceImpl(UserDao userDao){
         this.userDao = userDao;
     }


     public List<User> handleGetAllUsers(){
         return userDao.getAllUsers();
     }


     public User handleGetUserById(int id){
         return userDao.getUserById(id);
     }

     public int handleAddUser( User user ){
         return userDao.addUser(user);
     }

     public int handleUpdateUserById(User user,int id){
         return userDao.updateUserById(user,id);
     }

     public int handleDeleteUserById(int id){
         return userDao.deleteUserById(id);
     }

 }
