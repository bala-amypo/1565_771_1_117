// package com.example.demo.service.impl;

// import com.example.demo.entity.PolicyRule;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.service.PolicyRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class PolicyRuleServiceImpl implements PolicyRuleService {

//     private final PolicyRuleRepository repo;

//     public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public PolicyRule createRule(PolicyRule rule) {
//         return repo.save(rule);
//     }

//     @Override
//     public PolicyRule updateRule(Long id, PolicyRule rule) {
//         PolicyRule existing = repo.findById(id).orElseThrow();
//         existing.setRuleCode(rule.getRuleCode());
//         existing.setDescription(rule.getDescription());
//         existing.setSeverity(rule.getSeverity());
//         existing.setActive(rule.getActive());
//         return repo.save(existing);
//     }

//     @Override
//     public List<PolicyRule> getActiveRules() {
//         return repo.findByActiveTrue();
//     }

//     @Override
//     public List<PolicyRule> getAllRules() {
//         return repo.findAll();
//     }

//     @Override
//     public PolicyRule getRuleByCode(String ruleCode) {
//         return repo.findByRuleCode(ruleCode).orElse(null);
//     }
//}
package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    public PolicyRule createRule(PolicyRule rule) {
        return repo.save(rule);
    }

    public PolicyRule updateRule(Long id, PolicyRule rule) {
        rule.setId(id);
        return repo.save(rule);
    }

    public List<PolicyRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }

    public PolicyRule getRuleByCode(String ruleCode){
    return repo.findByRuleCode(ruleCode);
    }

}

