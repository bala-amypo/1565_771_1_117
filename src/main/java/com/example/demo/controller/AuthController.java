package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register() {
        return "REGISTER OK";
    }

    @PostMapping("/login")
    public String login() {
        return "JWT_TOKEN";
    }
}
