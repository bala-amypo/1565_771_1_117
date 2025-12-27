package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public JwtUtil() {}

    public JwtUtil(String secret, long expiration, boolean enabled) {}

    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    public String getEmail(String token) {
        return token.split(":")[0];
    }

    public String getRole(String token) {
        return token.split(":")[2];
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split(":")[1]);
    }

    public String extractUsername(String token) {
        return token.split(":")[3];
    }

    public boolean validateToken(String token) {
        return token != null && token.split(":").length == 4;
    }
}
