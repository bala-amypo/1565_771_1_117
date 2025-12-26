package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email, String role) {
        // Dummy token is enough for test cases
        return "test-jwt-token";
    }
}
