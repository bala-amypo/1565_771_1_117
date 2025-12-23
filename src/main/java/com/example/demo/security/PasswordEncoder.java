package com.example.demo.security;

public interface PasswordEncoder {
    String encode(String rawPassword);
}
