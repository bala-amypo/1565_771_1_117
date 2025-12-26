package com.example.demo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@SecurityRequirement(name = "")   // ⬅️ THIS LINE REMOVES LOCK
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
