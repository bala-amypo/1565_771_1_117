package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserAccountService userService; 

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {
        // This line was failing because the method didn't exist in the service
        boolean isValid = userService.verifyUser(user.getUsername(), user.getPassword());
        
        if (isValid) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}