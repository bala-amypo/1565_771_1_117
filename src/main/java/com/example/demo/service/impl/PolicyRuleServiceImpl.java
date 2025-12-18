package com.example.demo1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.entity.PolicyRule;
import com.example.demo1.service.PolicyRuleService;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    List<PolicyRule> rules = new ArrayList<>();
    long id = 1;

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        rule.setId(id++);
        rules.add(rule);
        return rule;
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        for (PolicyRule r : rules) {
            if (r.getId()==id)
                
                {
                r.setRuleCode(rule.getRuleCode());
                r.setDescription(rule.getDescription());
                r.setSeverity(rule.getSeverity());
                r.setConditionsJson(rule.getConditionsJson());
                r.setActive(rule.getActive());
                return r;
            }
        }
        return null;
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        List<PolicyRule> activeRules = new ArrayList<>();
        for (PolicyRule r : rules) {
            if (Boolean.TRUE.equals(r.getActive())) {
                activeRules.add(r);
            }
        }
        return activeRules;
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return rules;
    }

    @Override
    public PolicyRule getRuleByCode(String ruleCode) {
        for (PolicyRule r : rules) {
            if (r.getRuleCode().equals(ruleCode)) {
                return r;
            }
        }
        return null;
    }
}
