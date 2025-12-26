package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String username, Long userId, String role) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String getEmail(String token) {
        return "test@example.com";
    }

    public String getRole(String token) {
        return "USER";
    }

    public Long getUserId(String token) {
        return 1L;
    }
}
