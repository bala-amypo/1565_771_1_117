package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.UserAccount;
import com.example.demo1.service.UserAccountService;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = userAccountService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
        return ResponseEntity.status(201)
                .body(userAccountService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(200)
                .body(userAccountService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserAccount> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.status(200)
                .body(userAccountService.findByUsername(username));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUser(@PathVariable Long id, @RequestBody String user) {

        return ResponseEntity.status(200).body(userAccountService.updateUserStatus(id, user));
    }
}
