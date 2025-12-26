package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // REQUIRED BY TEST CASES
    public JwtUtil(String secret, long expiration, boolean enabled) {
    }

    // REQUIRED BY SPRING
    public JwtUtil() {
    }

    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.split(":").length == 4;
    }

    public String getEmail(String token) {
        return token.split(":")[0];
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split(":")[1]);
    }

    public String getRole(String token) {
        return token.split(":")[2];
    }

    public String getUsername(String token) {
        return token.split(":")[3];
    }
}
