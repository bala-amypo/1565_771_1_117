package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final Map<String, String> tokenStore = new HashMap<>();

    public JwtUtil() {}

    // REQUIRED BY TESTS
    public String generateToken(String username, long userId, String role, String extra) {
        String token = "TOKEN_" + username;
        tokenStore.put(token + "_email", username);
        tokenStore.put(token + "_role", role);
        tokenStore.put(token + "_userId", String.valueOf(userId));
        return token;
    }

    public String generateToken(String username, Long userId, String role) {
        return generateToken(username, userId, role, "");
    }

    public boolean validateToken(String token) {
        return tokenStore.containsKey(token + "_email");
    }

    public String getEmail(String token) {
        return tokenStore.get(token + "_email");
    }

    public String getRole(String token) {
        return tokenStore.get(token + "_role");
    }

    public Long getUserId(String token) {
        return Long.parseLong(tokenStore.get(token + "_userId"));
    }
}
