package com.example.demo.security;

public class JwtUtil {

    public JwtUtil(String secret, long validity, boolean testMode) {
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return username + "|" + userId + "|" + email + "|" + role;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public String getEmail(String token) {
        return token.split("\\|")[2];
    }

    public String getRole(String token) {
        return token.split("\\|")[3];
    }

    public Long getUserId(String token) {
        return Long.valueOf(token.split("\\|")[1]);
    }
}
