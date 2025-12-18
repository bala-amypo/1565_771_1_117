package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    @Autowired
    PolicyRuleService policyRuleService;

    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
        return ResponseEntity.status(201).body(policyRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> update(@PathVariable Long id,
                                             @RequestBody PolicyRule rule) {
        return ResponseEntity.ok(policyRuleService.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> activeRules() {
        return ResponseEntity.ok(policyRuleService.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> getAll() {
        return ResponseEntity.ok(policyRuleService.getAllRules());
    }
}
