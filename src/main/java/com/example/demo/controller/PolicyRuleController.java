// package com.example.demo.controller;

// import com.example.demo.entity.PolicyRule;
// import com.example.demo.service.PolicyRuleService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/rules")
// public class PolicyRuleController {

//     private final PolicyRuleService policyRuleService;

//     public PolicyRuleController(PolicyRuleService policyRuleService) {
//         this.policyRuleService = policyRuleService;
//     }

//     @PostMapping
//     public ResponseEntity<PolicyRule> createRule(@RequestBody PolicyRule rule) {
//         return ResponseEntity.ok(policyRuleService.createRule(rule));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<PolicyRule> updateRule(
//             @PathVariable Long id,
//             @RequestBody PolicyRule rule) {
//         return ResponseEntity.ok(policyRuleService.updateRule(id, rule));
//     }

//     @GetMapping("/active")
//     public ResponseEntity<List<PolicyRule>> getActiveRules() {
//         return ResponseEntity.ok(policyRuleService.getActiveRules());
//     }

//     @GetMapping
//     public ResponseEntity<List<PolicyRule>> getAllRules() {
//         return ResponseEntity.ok(policyRuleService.getAllRules());
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule r) {
        return ResponseEntity.ok(service.createRule(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> update(@PathVariable Long id,
                                             @RequestBody PolicyRule r) {
        return ResponseEntity.ok(service.updateRule(id, r));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> active() {
        return ResponseEntity.ok(service.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
}

