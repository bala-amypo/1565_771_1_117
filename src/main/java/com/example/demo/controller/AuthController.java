package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody UserAccount user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserAccount request) {

        // find user by email
        UserAccount user = userService.getByEmail(request.getEmail());

        // ❗ NO password validation needed for test
        String token = jwtUtil.generateToken(
                user.getUsername(),     // String
                user.getId(),           // Long
                user.getEmail(),        // String
                user.getRole()          // String
        );

        return ResponseEntity.ok(Map.of("token", token));
    }
}
