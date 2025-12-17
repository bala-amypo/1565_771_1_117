package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.entity.LoginEvent;
import com.example.demo1.service.LoginEventService;

@Service
public class LoginEventServiceImpl implements LoginEventService{
    List<LoginEvent> events =new ArrayList<>();
    long id=1;
     public LoginEvent recordLogin(LoginEvent event) {
        event.setId((long) id++);
        events.add(event);
        return event;
    }
    public List<LoginEvent> getEventByUser(Long userId){
        List<LoginEvent> result =new ArrayList<>();
        for(LoginEvent e: events){
            if(e.getUserId()==userId){
                result.add(e);
            }
        }
        return result;
    }
    public List<LoginEvent> getSuspiciousLogins(Long userId){
        List<LoginEvent> result = new ArrayList<>();
        for(LoginEvent e : events){
            if(e.getUserId()==userId && "Falied"==(e.getLoginStatus())){
                result.add(e);
            }
        }
        return result;
    }
    public List<LoginEvent> getAllEvents(){
        return events;
    }
}
