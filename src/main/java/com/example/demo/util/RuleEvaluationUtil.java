package com.example.demo.util;

import java.time.LocalDateTime;
import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class RuleEvaluationUtil {

    PolicyRuleRepository ruleRepo;
    ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository r, ViolationRecordRepository v) {
        ruleRepo = r;
        violationRepo = v;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = ruleRepo.findByActiveTrue();
        for (PolicyRule r : rules) {
            if (r.getConditionsJson() != null &&
                r.getConditionsJson().contains(event.getLoginStatus())) {
                ViolationRecord v = new ViolationRecord();
                v.setSeverity(r.getSeverity());
                v.setDetectedAt(LocalDateTime.now());
                v.setResolved(false);
                violationRepo.save(v);
            }
        }
    }
}
