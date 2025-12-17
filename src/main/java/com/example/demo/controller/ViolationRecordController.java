package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.ViolationRecord;
import com.example.demo1.service.ViolationRecordService;

@RestController
@RequestMapping("/violations")
public class ViolationRecordController {

    @Autowired
    ViolationRecordService violationRecordService;

    @PostMapping
    public ResponseEntity<ViolationRecord> logViolation(@RequestBody ViolationRecord violation) {
        return ResponseEntity.status(201)
                .body(violationRecordService.logViolation(violation));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getViolationsByUser(@PathVariable Long userId) {
        return ResponseEntity.status(200)
                .body(violationRecordService.getViolationsByUser(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViolationRecord> markResolved(@PathVariable Long id) {
        return ResponseEntity.status(200)
                .body(violationRecordService.markResolved(id));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnResolvedViolations() {
        return ResponseEntity.status(200)
                .body(violationRecordService.getUnResolvedViolations());
    }

    @GetMapping
    public ResponseEntity<List<ViolationRecord>> getAllViolations() {
        return ResponseEntity.status(200)
                .body(violationRecordService.getAllViolations());
    }
}
