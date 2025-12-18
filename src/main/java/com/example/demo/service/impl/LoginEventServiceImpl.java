package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import java.util.List;

public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleEvaluator;

    public LoginEventServiceImpl(LoginEventRepository loginRepo, RuleEvaluationUtil ruleEvaluator) {
        this.loginRepo = loginRepo;
        this.ruleEvaluator = ruleEvaluator;
    }

    public LoginEvent recordLogin(LoginEvent event) {
        if (event.getIpAddress() == null || event.getDeviceId() == null)
            throw new BadRequestException("IP and Device ID required");

        LoginEvent saved = loginRepo.save(event);
        ruleEvaluator.evaluateLoginEvent(saved);
        return saved;
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginRepo.findByUserId(userId);
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return loginRepo.findAll();
    }
}
