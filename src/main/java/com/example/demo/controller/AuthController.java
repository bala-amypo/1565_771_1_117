package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

   @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {

    UserAccount user = userService.findByUsername(request.getUsername());

    if (user == null) {
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    // ✅ CORRECT PASSWORD CHECK
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    String token = jwtUtil.generateToken(
            user.getEmail(),
            user.getId(),
            user.getRole(),
            user.getUsername()
    );

    JwtResponse response = new JwtResponse(
            token,
            user.getId(),
            user.getRole(),
            user.getUsername()
    );

    return ResponseEntity.ok(response);
}
}