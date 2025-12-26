package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.split(":").length == 4;
    }
}
