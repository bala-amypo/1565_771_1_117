package com.example.demo1.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
    @Id
    private int id;
    private String employeeId;
    private String username;
    private String email;
    private String password;
    private String role;
    private String status;
    private LocalDateTime createdAt;
    public UserAccount() {
    }
    public UserAccount(String employeeId, String username, String email, String password, String role, String status,
            LocalDateTime createdAt) {
        this.employeeId = employeeId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    

}
package com.example.demo1.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class LoginEvent {
    @Id
    private long id;
    private long userId;
    private String ipAddress;
    private String location;
    private String deviceId;
    private LocalDateTime timestamp;
    private String loginStatus;
    public LoginEvent() {
    }
    public LoginEvent(long id, long userId, String ipAddress, String location, String deviceId, LocalDateTime timestamp,
            String loginStatus) {
        this.id = id;
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.location = location;
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.loginStatus = loginStatus;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getLoginStatus() {
        return loginStatus;
    }
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

}








package com.example.demo1.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ViolationRecord {
    @Id
    private long id;
    private long userId;
    private long PolicyRuleId;
    private long eventId;
    private String violationType;
    private String details;
    private String severity;
    private LocalDateTime detectedAt;
    private Boolean resolved;
    public ViolationRecord() {
    }
    public ViolationRecord(long userId, long policyRuleId, long eventId, String violationType, String details,
            String severity, LocalDateTime detectedAt, Boolean resolved) {
        this.userId = userId;
        PolicyRuleId = policyRuleId;
        this.eventId = eventId;
        this.violationType = violationType;
        this.details = details;
        this.severity = severity;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getPolicyRuleId() {
        return PolicyRuleId;
    }
    public void setPolicyRuleId(long policyRuleId) {
        PolicyRuleId = policyRuleId;
    }
    public long getEventId() {
        return eventId;
    }
    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
    public String getViolationType() {
        return violationType;
    }
    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }
    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
    public Boolean getResolved() {
        return resolved;
    }
    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
    
}

