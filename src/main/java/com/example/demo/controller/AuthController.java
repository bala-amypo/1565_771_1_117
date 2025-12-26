package com.example.demo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@SecurityRequirement(name = "") // ❌ REMOVE SECURITY FROM CONTROLLER
public class AuthController {

    @PostMapping("/register")
    @Operation(security = {}) // 🔓 NO LOCK
    public String register() {
        return "REGISTER OK";
    }

    @PostMapping("/login")
    @Operation(security = {}) // 🔓 NO LOCK
    public String login() {
        return "LOGIN OK";
    }
}
