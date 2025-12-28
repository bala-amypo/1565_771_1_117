package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "violation_record")
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserAccount user;

    @OneToOne
    @JoinColumn(name = "event_id")
    private LoginEvent loginEvent;

    @ManyToOne
    @JoinColumn(name = "policy_rule_id")
    private PolicyRule policyRule;

    private String violationType;
    private String details;
    private String severity;
    private Boolean resolved;
    private LocalDateTime detectedAt;

    public ViolationRecord() {}

    public ViolationRecord(UserAccount user, LoginEvent loginEvent, PolicyRule policyRule, String violationType, String details, String severity) {
        this.user = user;
        this.loginEvent = loginEvent;
        this.policyRule = policyRule;
        this.violationType = violationType;
        this.details = details;
        this.severity = severity;
        this.resolved = false;
        this.detectedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public UserAccount getUser() { return user; }
    public void setUser(UserAccount user) { this.user = user; }
    public LoginEvent getLoginEvent() { return loginEvent; }
    public void setLoginEvent(LoginEvent loginEvent) { this.loginEvent = loginEvent; }
    public PolicyRule getPolicyRule() { return policyRule; }
    public void setPolicyRule(PolicyRule policyRule) { this.policyRule = policyRule; }
    public String getViolationType() { return violationType; }
    public void setViolationType(String violationType) { this.violationType = violationType; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }
}