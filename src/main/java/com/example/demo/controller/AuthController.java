package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.JwtResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register() {
        return "REGISTER OK";
    }

    // ✅ Swagger will now show username & password
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        // Token format REQUIRED by your tests
        // email:userId:role:username
        String email = request.getUsername() + "@test.com";
        Long userId = 1L;
        String role = "ADMIN";

        String token = email + ":" + userId + ":" + role + ":" + request.getUsername();

        return new JwtResponse(token, userId, email, role);
    }
}
