package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login() {
        return jwtUtil.generateToken(
                "test@test.com",
                1L,
                "USER",
                "testuser"
        );
    }

    @PostMapping("/register")
    public String register() {
        return "Registered successfully";
    }
}
