package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil ruleUtil;

    public LoginEventServiceImpl(LoginEventRepository repo, RuleEvaluationUtil ruleUtil) {
        this.repo = repo;
        this.ruleUtil = ruleUtil;
    }

    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = repo.save(event);
        ruleUtil.evaluateLoginEvent(saved);
        return saved;
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }
    @Override
    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
}

}
