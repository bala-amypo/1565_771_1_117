package com.example.demo.controller;

import java.util.*;
import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;

public class PolicyRuleController {

    PolicyRuleService svc;

    public PolicyRuleController(PolicyRuleService s) {
        svc = s;
    }

    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(svc.getAllRules());
    }
}
