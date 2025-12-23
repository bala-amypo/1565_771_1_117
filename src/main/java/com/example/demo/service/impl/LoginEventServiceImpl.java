package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

@Service   // ⭐ REQUIRED — creates Spring bean
public class LoginEventServiceImpl implements LoginEventService {

    private final List<LoginEvent> events = new ArrayList<>();

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        events.add(event);
        return event;
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return events;
    }
}
