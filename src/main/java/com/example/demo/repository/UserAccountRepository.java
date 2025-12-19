package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepository {
    public UserAccount save(UserAccount user) {
        return user;
    }
}
