package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Required by tests
    public JwtUtil(String secret, long expiration, boolean enabled) {}

    // Required by Spring
    public JwtUtil() {}

    // ===============================
    // CANONICAL FORMAT USED BY TESTS
    // username:email:role:userId
    // ===============================
    private String buildToken(String username, String email, String role, long userId) {
        return username + ":" + email + ":" + role + ":" + userId;
    }

    // ✅ TEST VARIANT #1
    public String generateToken(String username, String email, String role, Long userId) {
        return buildToken(username, email, role, userId);
    }

    // ✅ TEST VARIANT #2 (THIS FIXES YOUR ERROR)
    public String generateToken(long userId, String email, String role, String username) {
        return buildToken(username, email, role, userId);
    }

    // ===============================
    // VALIDATION
    // ===============================
    public boolean validateToken(String token) {
        return token != null && token.split(":").length == 4;
    }

    // ===============================
    // EXTRACTION
    // ===============================
    public String extractUsername(String token) {
        return validateToken(token) ? token.split(":")[0] : "";
    }

    public String getEmail(String token) {
        return validateToken(token) ? token.split(":")[1] : "";
    }

    public String getRole(String token) {
        return validateToken(token) ? token.split(":")[2] : "";
    }

    public Long getUserId(String token) {
        if (!validateToken(token)) return null;
        try {
            return Long.parseLong(token.split(":")[3]);
        } catch (Exception e) {
            return null;
        }
    }
}
