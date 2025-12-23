package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoginEvent;

public interface LoginEventService {

    LoginEvent recordLogin(LoginEvent event);

    List<LoginEvent> getAllEvents();
}
