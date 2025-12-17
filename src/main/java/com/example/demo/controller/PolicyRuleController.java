package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.PolicyRule;
import com.example.demo1.service.PolicyRuleService;

@RestController
@RequestMapping("/rules")
public class PolicyRuleController {

    @Autowired
    PolicyRuleService policyRuleService;

    @PostMapping
    public ResponseEntity<PolicyRule> createRule(@RequestBody PolicyRule rule) {
        return ResponseEntity.status(201)
                .body(policyRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> updateRule(@PathVariable Long id,
                                                 @RequestBody PolicyRule rule) {
        return ResponseEntity.status(200)
                .body(policyRuleService.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> getActiveRules() {
        return ResponseEntity.status(200)
                .body(policyRuleService.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> getAllRules() {
        return ResponseEntity.status(200)
                .body(policyRuleService.getAllRules());
    }

    @GetMapping("/{ruleCode}")
    public ResponseEntity<PolicyRule> getRuleByCode(@PathVariable String ruleCode) {
        return ResponseEntity.status(200)
                .body(policyRuleService.getRuleByCode(ruleCode));
    }
}
