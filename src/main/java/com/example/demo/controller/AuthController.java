package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        var user = userService.getByEmail(request.getUsername());

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                user.getRole(),
                user.getUsername()
        );

        return ResponseEntity.ok(token);
    }
}
