// package com.example.demo.controller;

// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.service.ViolationRecordService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/violations")
// public class ViolationRecordController {

//     private final ViolationRecordService violationService;

//     public ViolationRecordController(ViolationRecordService violationService) {
//         this.violationService = violationService;
//     }

//     @PostMapping
//     public ResponseEntity<ViolationRecord> create(@RequestBody ViolationRecord record) {
//         if (record.getPolicyRule() == null) {
//             throw new IllegalArgumentException("policyRule must be provided");
//         }
//         return ResponseEntity.ok(violationService.logViolation(record));
// }

//     @GetMapping("/user/{userId}")
//     public ResponseEntity<List<ViolationRecord>> getByUser(
//             @PathVariable Long userId) {
//         return ResponseEntity.ok(violationService.getViolationsByUser(userId));
//     }

//     @PutMapping("/{id}/resolve")
//     public ResponseEntity<ViolationRecord> resolveViolation(
//             @PathVariable Long id) {
//         return ResponseEntity.ok(violationService.markResolved(id));
//     }

//     @GetMapping("/unresolved")
//     public ResponseEntity<List<ViolationRecord>> getUnresolved() {
//         return ResponseEntity.ok(violationService.getUnresolvedViolations());
//     }

//     @GetMapping
//     public ResponseEntity<List<ViolationRecord>> getAll() {
//         return ResponseEntity.ok(violationService.getAllViolations());
//     }
//}
package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord v) {
        return ResponseEntity.ok(service.logViolation(v));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getViolationsByUser(userId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.markResolved(id));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> unresolved() {
        return ResponseEntity.ok(service.getUnresolvedViolations());
    }

    @GetMapping
    public ResponseEntity<List<ViolationRecord>> all() {
        return ResponseEntity.ok(service.getAllViolations());
    }
}


