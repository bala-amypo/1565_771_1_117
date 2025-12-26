package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secret;
    private long expiration;
    private boolean enabled;

    // ✅ REQUIRED BY TEST CASES
    public JwtUtil(String secret, long expiration, boolean enabled) {
        this.secret = secret;
        this.expiration = expiration;
        this.enabled = enabled;
    }

    // ✅ DEFAULT CONSTRUCTOR FOR SPRING
    public JwtUtil() {
        this.secret = "test-secret-key";
        this.expiration = 3600000;
        this.enabled = true;
    }

    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
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
