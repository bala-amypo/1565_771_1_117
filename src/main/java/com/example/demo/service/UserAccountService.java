package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserAccount;







public interface UserAccountService{
    UserAccount createUser(UserAccount user);
    UserAccount getUserById(Long id);
    UserAccount updateUserStatus(Long id,String status);
    List<UserAccount> getAllUsers();
    UserAccount findByUsername(String username);
}