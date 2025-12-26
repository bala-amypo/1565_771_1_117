package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
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

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {

        UserAccount dbUser = userService.getByEmail(user.getEmail());

        return jwtUtil.generateToken(
                dbUser.getEmail(),
                dbUser.getId(),
                dbUser.getRole(),
                dbUser.getUsername()
        );
    }
}
