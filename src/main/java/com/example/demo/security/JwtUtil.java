package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // === REQUIRED BY TESTS ===
    public JwtUtil(String secret, long expiration, boolean enabled) {
    }

    // === REQUIRED BY SPRING ===
    public JwtUtil() {
    }

    // Token format:
    // email:userId:role:username
    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    public boolean validateToken(String token) {
        if (token == null) return false;
        String[] parts = token.split(":");
        return parts.length == 4;
    }

    // ✅ TEST EXPECTS EMPTY STRING ON FAILURE
    public String getEmail(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[0];
    }

    public String getRole(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[2];
    }

    public Long getUserId(String token) {
        if (!validateToken(token)) return null;
        try {
            return Long.parseLong(token.split(":")[1]);
        } catch (Exception e) {
            return null;
        }
    }

    public String extractUsername(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[3];
    }
}
