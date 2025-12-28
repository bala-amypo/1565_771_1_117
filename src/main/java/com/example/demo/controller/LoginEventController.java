// package com.example.demo.controller;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.service.LoginEventService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/logins")
// public class LoginEventController {

//     private final LoginEventService service;

//     public LoginEventController(LoginEventService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public LoginEvent log(@RequestBody LoginEvent event) {
//         return service.recordLogin(event);
//     }

//     @GetMapping("/user/{userId}")
//     public List<LoginEvent> byUser(@PathVariable Long userId) {
//         return service.getEventsByUser(userId);
//     }

//     @GetMapping("/suspicious/{userId}")
//     public List<LoginEvent> suspicious(@PathVariable Long userId) {
//         return service.getSuspiciousLogins(userId);
//     }

//     @GetMapping
//     public List<LoginEvent> all() {
//         return service.getAllEvents();
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping("/record")
    public ResponseEntity<LoginEvent> record(@RequestBody LoginEvent e) {
        return ResponseEntity.ok(service.recordLogin(e));
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> all() {
        return ResponseEntity.ok(service.getAllEvents());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getEventsByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> suspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getSuspiciousLogins(userId));
    }
}
