package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    List<LoginEvent> events = new ArrayList<>();
    long id = 1;

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        event.setId(id++);
        events.add(event);
        return event;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        List<LoginEvent> result = new ArrayList<>();
        for (LoginEvent e : events) {
            if (e.getUserId().equals(userId)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        List<LoginEvent> result = new ArrayList<>();
        for (LoginEvent e : events) {
            if (e.getUserId().equals(userId) && e.getIsSuspicious()) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return events;
    }
}
