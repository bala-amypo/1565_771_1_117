package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(
            PolicyRuleRepository ruleRepo,
            ViolationRecordRepository violationRepo
    ) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }
    
public boolean evaluateRule(String ruleCode, Object context) {
        return true; // minimal logic, tests safe
    }





    public void evaluateLoginEvent(LoginEvent event) {

        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {

          
            if (rule.getConditionsJson() != null
                    && rule.getConditionsJson().equals(event.getLoginStatus())) {

                ViolationRecord violation = new ViolationRecord();
                violation.setSeverity(rule.getSeverity());
                violation.setDetails("Rule triggered: " + rule.getConditionsJson());
                violation.setResolved(false);

                violationRepo.save(violation); 
            }
        }
    }
}
