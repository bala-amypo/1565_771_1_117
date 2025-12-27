package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateUserStatus(id, status);
    }
}
