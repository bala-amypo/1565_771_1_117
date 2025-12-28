// package com.example.demo.util;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.entity.PolicyRule;
// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.repository.ViolationRecordRepository;

// import org.springframework.stereotype.Component;

// import java.time.LocalDateTime;
// import java.util.List;

// @Component
// public class RuleEvaluationUtil {

//     private final PolicyRuleRepository ruleRepo;
//     private final ViolationRecordRepository violationRepo;

//     public RuleEvaluationUtil(
//             PolicyRuleRepository ruleRepo,
//             ViolationRecordRepository violationRepo
//     ) {
//         this.ruleRepo = ruleRepo;
//         this.violationRepo = violationRepo;
//     }

//     /**
//      * Evaluate a login event against all active rules
//      */
//     public void evaluateLoginEvent(LoginEvent event) {

//         List<PolicyRule> rules = ruleRepo.findByActiveTrue();

//         for (PolicyRule rule : rules) {
//             if (matches(rule, event)) {

//                 ViolationRecord violation = new ViolationRecord();
//                 // Use the new getUserId() method directly
// violation.setUserId(event.getUserId());
//                 violation.setEventId(event.getId());
//                 violation.setSeverity(rule.getSeverity());
//                 violation.setViolationType(rule.getRuleCode());
//                 violation.setDetails("Rule triggered: " + rule.getRuleCode());
//                 violation.setDetectedAt(LocalDateTime.now());
//                 violation.setResolved(false);

//                 violationRepo.save(violation);
//             }
//         }
//     }

//     /**
//      * Simple rule matcher (can be extended later)
//      */
//     private boolean matches(PolicyRule rule, LoginEvent event) {
//         String condition = rule.getConditionsJson();

//         if (condition == null) return false;

//         // Simple matching examples
//         if (condition.contains("FAILED") &&
//                 "FAILED".equalsIgnoreCase(event.getLoginStatus())) {
//             return true;
//         }

//         if (condition.contains("DEVICE") &&
//                 event.getDeviceId() != null) {
//             return true;
//         }

//         return false;
//     }
// }
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

        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {
            ViolationRecord violation = new ViolationRecord();

            violation.setUserId(event.getUserId());
            violation.setEventId(event.getId());
            violation.setViolationType(rule.getRuleCode());
            violation.setDetails("Policy violated: " + rule.getDescription());
            violation.setSeverity(rule.getSeverity());
            violation.setDetectedAt(LocalDateTime.now());
            violation.setResolved(false);

            violationRepo.save(violation);
        }
    }
}
