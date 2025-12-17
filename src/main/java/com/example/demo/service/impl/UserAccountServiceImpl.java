package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.entity.UserAccount;
import com.example.demo1.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    List<UserAccount> users = new ArrayList<>();
    long id = 1;

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setId(id++);
        users.add(user);
        return user;
    }

    @Override
    public UserAccount getUserById(Long id) {
        for (UserAccount u : users) {
            if (u.getId()==id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return users;
    }

    @Override
    public UserAccount findByUsername(String username) {
        for (UserAccount u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        for (UserAccount u : users) {
            if (u.getId()==id) {
                u.setStatus(status);
                return u;
            }
        }
        return null;
    }
}
