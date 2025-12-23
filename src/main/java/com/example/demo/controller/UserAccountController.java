package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;

public class UserAccountController {

    UserAccountService svc;

    public UserAccountController(UserAccountService s) {
        svc = s;
    }

    public ResponseEntity<UserAccount> create(UserAccount u) {
        return ResponseEntity.ok(svc.createUser(u));
    }
}
