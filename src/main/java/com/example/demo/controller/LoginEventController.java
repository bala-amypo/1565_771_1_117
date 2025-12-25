package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    // POST /api/logins/record
    @PostMapping("/record")
    public ResponseEntity<LoginEvent> record(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(loginEventService.recordLogin(event));
    }

    // GET /api/logins
    @GetMapping
    public ResponseEntity<List<LoginEvent>> all() {
        return ResponseEntity.ok(loginEventService.getAllEvents());
    }

    // GET /api/logins/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getEventsByUser(userId));
    }

    // GET /api/logins/suspicious/{userId}
    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> suspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getSuspiciousLogins(userId));
    }
}
