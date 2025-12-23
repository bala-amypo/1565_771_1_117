package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAccountServiceImpl implements UserAccountService {

    UserAccountRepository repo;
    PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository r, PasswordEncoder e) {
        repo = r; encoder = e;
    }

    public UserAccount createUser(UserAccount u) {
        u.setPassword(encoder.encode(u.getPassword()));
        if (u.getStatus() == null) u.setStatus("ACTIVE");
        u.setCreatedAt(LocalDateTime.now());
        return repo.save(u);
    }

    public UserAccount getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = getUserById(id);
        u.setStatus(status);
        return repo.save(u);
    }

    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    public Optional<UserAccount> findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
