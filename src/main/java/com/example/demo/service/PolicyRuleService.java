package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.PolicyRule;

public interface PolicyRuleService {
    PolicyRule createRule(PolicyRule r);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
}
