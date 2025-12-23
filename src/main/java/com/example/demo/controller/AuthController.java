package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;

/**
 * Authentication Controller
 * Handles user registration and simple login
 */
public class AuthController {

    UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    /**
     * Register a new user
     */
    public ResponseEntity<UserAccount> register(UserAccount user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    /**
     * Simple login (no JWT / no security)
     */
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login successful");
    }
}
