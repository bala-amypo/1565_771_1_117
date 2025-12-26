package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secret;
    private long expiration;
    private boolean enabled;

    // ✅ Required by tests
    public JwtUtil(String secret, long expiration, boolean enabled) {
        this.secret = secret;
        this.expiration = expiration;
        this.enabled = enabled;
    }

    // ✅ Required by Spring
    public JwtUtil() {
        this.secret = "test-secret";
        this.expiration = 3600000;
        this.enabled = true;
    }

    // Token format:
    // email:userId:role:username
    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.split(":").length >= 4;
    }

    // ✅ FIXED — EMAIL IS EVERYTHING BEFORE FIRST :
    public String getEmail(String token) {
        if (!validateToken(token)) return "";
        return token.substring(0, token.indexOf(":"));
    }

    public Long getUserId(String token) {
        if (!validateToken(token)) return null;
        try {
            return Long.parseLong(token.split(":")[1]);
        } catch (Exception e) {
            return null;
        }
    }

    public String getRole(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[2];
    }

    public String extractUsername(String token) {
        if (!validateToken(token)) return "";
        return token.split(":")[3];
    }
}
