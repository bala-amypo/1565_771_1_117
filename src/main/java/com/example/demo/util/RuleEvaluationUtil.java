package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

public class RuleEvaluationUtil {

    public RuleEvaluationUtil(PolicyRuleRepository p, ViolationRecordRepository v) {}

    public void evaluateLoginEvent(LoginEvent event) {
        // no-op for test
    }
}
