// package com.example.demo.controller;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.service.UserAccountService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/users")
// public class UserAccountController {

//     private final UserAccountService userAccountService;

//     public UserAccountController(UserAccountService userAccountService) {
//         this.userAccountService = userAccountService;
//     }

//     @PostMapping
//     public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
//         return ResponseEntity.ok(userAccountService.createUser(user));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<UserAccount> getUser(@PathVariable Long id) {
//         return ResponseEntity.ok(userAccountService.getUserById(id));
//     }

//     @PutMapping("/{id}/status")
//     public ResponseEntity<UserAccount> updateStatus(
//             @PathVariable Long id,
//             @RequestParam String status) {

//         return ResponseEntity.ok(userAccountService.updateUserStatus(id, status));
//     }

//     @GetMapping
//     public ResponseEntity<List<UserAccount>> getAllUsers() {
//         return ResponseEntity.ok(userAccountService.getAllUsers());
//     }
//}
package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.*;

public class UserAccountController {
    private final UserAccountService service;
    public UserAccountController(UserAccountService service) {
        this.service = service;
    }
    public ResponseEntity<UserAccount> create(UserAccount u) {
        return ResponseEntity.ok(service.createUser(u));
    }
}
