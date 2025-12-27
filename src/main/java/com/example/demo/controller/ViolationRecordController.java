package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

import org.springframework.http.ResponseEntity;
import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/violations")
@SecurityRequirement(name = "bearerAuth")  // 👈 THIS IS IMPORTANT
public class ViolationController {

    @GetMapping
    public List<String> getAllViolations() {
        return List.of("Violation 1", "Violation 2");
    }

    @PostMapping
    public String createViolation() {
        return "Violation Created";
    }

    @PutMapping("/{id}/resolve")
    public String resolveViolation(@PathVariable Long id) {
        return "Resolved " + id;
    }
}