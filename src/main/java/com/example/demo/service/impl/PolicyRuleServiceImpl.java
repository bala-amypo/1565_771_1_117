package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

public class PolicyRuleServiceImpl implements PolicyRuleService {

    PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository r) {
        repo = r;
    }

    public PolicyRule createRule(PolicyRule r) {
        return repo.save(r);
    }

    public List<PolicyRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }
}
