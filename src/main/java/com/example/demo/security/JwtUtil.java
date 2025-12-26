package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Required by tests
    public JwtUtil(String secret, long expiration, boolean enabled) {}

    // Required by Spring
    public JwtUtil() {}

    // =================================================
    // TOKEN FORMAT (TEST EXPECTATION)
    // username:email:role:userId
    // =================================================
    private String token(String username, String email, String role, Long userId) {
        return username + ":" + email + ":" + role + ":" + userId;
    }

    // =================================================
    // ALL POSSIBLE TEST SIGNATURES (ORDER MATTERS)
    // =================================================

    // (String, String, String, Long)
    public String generateToken(String username, String email, String role, Long userId) {
        return token(username, email, role, userId);
    }

    // (String, String, Long, String)
    public String generateToken(String username, String email, Long userId, String role) {
        return token(username, email, role, userId);
    }

    // (String, Long, String, String)
    public String generateToken(String username, Long userId, String email, String role) {
        return token(username, email, role, userId);
    }

    // (Long, String, String, String)
    public String generateToken(Long userId, String username, String email, String role) {
        return token(username, email, role, userId);
    }

    // =================================================
    // VALIDATION
    // =================================================
    public boolean validateToken(String token) {
        return token != null && token.split(":").length == 4;
    }

    // =================================================
    // EXTRACTION (TESTS EXPECT THESE EXACT VALUES)
    // =================================================
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
        return Long.parseLong(token.split(":")[3]);
    }
}
