package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> createRule(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(policyRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> updateRule(
            @PathVariable Long id,
            @RequestBody PolicyRule rule) {
        return ResponseEntity.ok(policyRuleService.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> getActiveRules() {
        return ResponseEntity.ok(policyRuleService.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> getAllRules() {
        return ResponseEntity.ok(policyRuleService.getAllRules());
    }
}
