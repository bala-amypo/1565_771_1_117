package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.LoginEvent;
import com.example.demo1.service.LoginEventService;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    @Autowired
    LoginEventService loginEventService;

    @PostMapping
    public ResponseEntity<LoginEvent> recordLogin(@RequestBody LoginEvent event) {
        return ResponseEntity.status(201)
                .body(loginEventService.recordLogin(event));
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> getAllEvents() {
        List<LoginEvent> events = loginEventService.getAllEvents();
        return ResponseEntity.status(200).body(events);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getEventsByUser(@PathVariable Long userId) {
        return ResponseEntity.status(200)
                .body(loginEventService.getEventByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> getSuspiciousLogins(@PathVariable Long userId) {
        return ResponseEntity.status(200)
                .body(loginEventService.getSuspiciousLogins(userId));
    }
}
