package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping
    public LoginEvent record(@RequestBody LoginEvent event) {
        return loginEventService.recordLogin(event);
    }

    @GetMapping
    public List<LoginEvent> getAll() {
        return loginEventService.getAllEvents();
    }
}
