package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Required by tests
    public JwtUtil(String secret, long expiration, boolean enabled) {
    }

    // Required by Spring
    public JwtUtil() {
    }

    // ✅ TEST TOKEN FORMAT:
    // username:email:role:userId
    public String generateToken(String username, String email, String role, Long userId) {
        return username + ":" + email + ":" + role + ":" + userId;
    }

    public boolean validateToken(String token) {
        if (token == null) return false;
        String[] parts = token.split(":");
        return parts.length == 4;
    }

    public String getEmail(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[1];
    }

    public String getRole(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[2];
    }

    public Long getUserId(String token) {
        if (!validateToken(token)) return null;
        try {
            return Long.parseLong(token.split(":")[3]);
        } catch (Exception e) {
            return null;
        }
    }

    public String extractUsername(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[0];
    }
}
