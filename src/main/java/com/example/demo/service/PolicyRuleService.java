


package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.entity.PolicyRule;









public interface PolicyRuleService{
    PolicyRule createRule(PolicyRule rule);
    PolicyRule updateRule(Long id,PolicyRule rule);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
    PolicyRule getRuleByCode(String ruleCode);
}