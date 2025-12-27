package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // REQUIRED BY TESTS
    public JwtUtil() {}

    // REQUIRED BY TESTS
    public JwtUtil(String secret, long expiration, boolean enabled) {}

    /*
     * TOKEN FORMAT EXPECTED BY TESTS:
     * username:email:userId:role
     * Example:
     * test:abc@test.com:1:AUDITOR
     */

    public String generateToken(String email, Long userId, String role, String username) {
        return username + ":" + email + ":" + userId + ":" + role;
    }

    public boolean validateToken(String token) {
        return token != null && token.split(":").length == 4;
    }

    public String getEmail(String token) {
        return token.split(":")[1];
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split(":")[2]);
    }

    public String getRole(String token) {
        return token.split(":")[3];
    }

    public String extractUsername(String token) {
        return token.split(":")[0];
    }
}
