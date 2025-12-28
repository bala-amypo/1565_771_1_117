package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> create(@RequestBody ViolationRecord record) {
        if (record.getPolicyRule() == null) {
            throw new IllegalArgumentException("policyRule must be provided");
        }
        return ResponseEntity.ok(service.logViolation(record));
}

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(violationService.getViolationsByUser(userId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolveViolation(
            @PathVariable Long id) {
        return ResponseEntity.ok(violationService.markResolved(id));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnresolved() {
        return ResponseEntity.ok(violationService.getUnresolvedViolations());
    }

    @GetMapping
    public ResponseEntity<List<ViolationRecord>> getAll() {
        return ResponseEntity.ok(violationService.getAllViolations());
    }
}
