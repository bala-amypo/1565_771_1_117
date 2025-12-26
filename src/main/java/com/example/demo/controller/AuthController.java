package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@SecurityRequirements  // 🔥 THIS REMOVES LOCK
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return "JWT_TOKEN";
    }
}
