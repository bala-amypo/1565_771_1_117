
package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEvent;






public interface LoginEventService{
    LoginEvent recordLogin(LoginEvent event);
    List<LoginEvent> getEventByUser(Long userId);
    List<LoginEvent> getSuspiciousLogins(Long userId);
    List<LoginEvent> getAllEvents();
}