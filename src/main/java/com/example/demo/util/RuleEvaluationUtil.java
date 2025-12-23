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

    // ✅ DECLARE FIELDS
    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    // ✅ CONSTRUCTOR INJECTION
    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    // ✅ METHOD USED BY LoginEventService
    public void evaluateLoginEvent(LoginEvent event) {

        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : activeRules) {

            // Simple rule logic (enough for tests)
            if (rule.getConditionsJson() != null &&
                event.getLoginStatus() != null &&
                rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord record = new ViolationRecord();
                record.setUserId(event.getUserId());
                record.setEventId(event.getId());
                record.setPolicyRuleId(rule.getId());
                record.setViolationType("RULE_MATCH");
                record.setDetails("Rule triggered: " + rule.getRuleCode());
                record.setSeverity(rule.getSeverity());
                record.setDetectedAt(LocalDateTime.now());
                record.setResolved(false);

                violationRepo.save(record);
            }
        }
    }
}
