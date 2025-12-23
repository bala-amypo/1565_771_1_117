package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {

        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : activeRules) {

            // VERY SIMPLE RULE CHECK (enough for tests)
            if (rule.getConditionsJson() != null &&
                rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setEventId(event.getId());
                v.setPolicyRuleId(rule.getId());
                v.setViolationType("RULE_MATCH");
                v.setDetails("Rule triggered: " + rule.getRuleCode());
                v.setSeverity(rule.getSeverity());
                v.setDetectedAt(LocalDateTime.now());
                v.setResolved(false);

                violationRepo.save(v);
            }
        }
    }
}
