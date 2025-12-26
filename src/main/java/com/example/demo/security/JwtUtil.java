package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component   // ✅ THIS LINE IS REQUIRED
public class JwtUtil {

    public JwtUtil() {
    }

    public String generateToken(String username, Long userId, String email, String role) {
        String payload = username + ":" + userId + ":" + email + ":" + role;
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return decode(token)[2];
    }

    public String getRole(String token) {
        return decode(token)[3];
    }

    public Long getUserId(String token) {
        return Long.parseLong(decode(token)[1]);
    }

    private String[] decode(String token) {
        return new String(Base64.getDecoder().decode(token)).split(":");
    }
}
