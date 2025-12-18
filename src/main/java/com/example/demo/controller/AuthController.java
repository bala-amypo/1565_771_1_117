package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired // This tells Spring to find the service and plug it in here
    UserAccountService userService; 

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login() {
        return "Login successful";
    }
}