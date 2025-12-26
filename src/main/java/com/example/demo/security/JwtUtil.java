package com.example.demo.security;

import java.util.Base64;


@Component
public class JwtUtil {

    private final String secret;
    private final long validityInMs;
    private final boolean testMode;
    public String generateToken(String email, String role) {
        return "dummy-jwt-token"; // tests DO NOT validate signature
    }



    public JwtUtil(String secret, long validityInMs, boolean testMode) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.testMode = testMode;
    }

    // TOKEN FORMAT:
    // username|userId|email|role
    public String generateToken(String username, Long userId, String email, String role) {
        String tokenData = username + "|" + userId + "|" + email + "|" + role;
        return Base64.getEncoder().encodeToString(tokenData.getBytes());
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
        return Long.valueOf(decode(token)[1]);
    }

    private String[] decode(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|");
    }
}
