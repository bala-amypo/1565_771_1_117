package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Violation Management", description = "APIs for managing policy violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @Operation(summary = "Create a violation record")
    @PostMapping
    public ResponseEntity<ViolationRecord> createViolation(
            @RequestBody ViolationRecord violation) {
        return ResponseEntity.ok(service.logViolation(violation));
    }

    @Operation(summary = "Get all violations")
    @GetMapping
    public ResponseEntity<List<ViolationRecord>> getAllViolations() {
        return ResponseEntity.ok(service.getAllViolations());
    }

    @Operation(summary = "Get violations by user ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getViolationsByUser(userId));
    }

    @Operation(summary = "Resolve a violation")
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolveViolation(@PathVariable Long id) {
        return ResponseEntity.ok(service.markResolved(id));
    }

    @Operation(summary = "Get unresolved violations")
    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnresolved() {
        return ResponseEntity.ok(service.getUnresolvedViolations());
    }
}
