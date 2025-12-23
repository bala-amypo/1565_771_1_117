package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.util.RuleEvaluationUtil;

public class LoginEventServiceImpl implements LoginEventService {

    LoginEventRepository repo;
    RuleEvaluationUtil util;

    public LoginEventServiceImpl(LoginEventRepository r, RuleEvaluationUtil u) {
        repo = r; util = u;
    }

    public LoginEvent recordLogin(LoginEvent e) {
        LoginEvent saved = repo.save(e);
        util.evaluateLoginEvent(saved);
        return saved;
    }

    public List<LoginEvent> getEventsByUser(Long id) {
        return repo.findByUserId(id);
    }

    public List<LoginEvent> getSuspiciousLogins(Long id) {
        return repo.findByUserIdAndLoginStatus(id, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
    }
}
