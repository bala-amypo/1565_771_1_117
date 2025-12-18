package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    @Autowired
    ViolationRecordService violationRecordService;

    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord violation) {
        return ResponseEntity.status(201).body(violationRecordService.logViolation(violation));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(violationRecordService.getViolationsByUser(userId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(violationRecordService.markResolved(id));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> unresolved() {
        return ResponseEntity.ok(violationRecordService.getUnresolvedViolations());
    }

    @GetMapping
    public ResponseEntity<List<ViolationRecord>> getAll() {
        return ResponseEntity.ok(violationRecordService.getAllViolations());
    }
}
