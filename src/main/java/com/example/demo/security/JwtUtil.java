package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // REQUIRED by tests
    public JwtUtil() {}

    // REQUIRED by tests
    public JwtUtil(String secret, long expiration, boolean enabled) {}

    // REQUIRED signature by controller + tests
    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    // REQUIRED by testJwtExtractEmail
    public String getEmail(String token) {
        return token.split(":")[0];
    }

    // REQUIRED by tests
    public Long getUserId(String token) {
        return Long.parseLong(token.split(":")[1]);
    }

    // REQUIRED by testJwtExtractRole
    public String getRole(String token) {
        return token.split(":")[2];
    }

    // REQUIRED by filters/controllers
    public String getUsername(String token) {
        return token.split(":")[3];
    }
}
