package com.example.demo.dto;

public class JwtResponse {

    private String token;
    private Long userId;
    private String role;
    private String username;

    public JwtResponse(String token, Long userId, String role, String username) {
        this.token = token;
        this.userId = userId;
        this.role = role;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }
}
