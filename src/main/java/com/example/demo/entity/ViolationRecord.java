// 
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "violation_record")
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✔ Proper relationship with UserAccount
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) 
    private UserAccount userId;

    @Column(name = "event_id")
    private Long eventId;

    private String violationType;
    private String details;
    private String severity;
    private Boolean resolved = false;
    private LocalDateTime detectedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "policy_rule_id")
    private PolicyRule policyRule;

    // Default Constructor
    public ViolationRecord() {}

    // Updated Parameterized Constructor
    public ViolationRecord(UserAccount userId, Long eventId, PolicyRule policyRule,
                           String violationType, String details, String severity) {
        this.userId = userId;
        this.eventId = eventId;
        this.policyRule = policyRule;
        this.violationType = violationType;
        this.details = details;
        this.severity = severity;
        this.resolved = false;
        this.detectedAt = LocalDateTime.now();
    }

    // -------------------- GETTERS & SETTERS --------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserAccount getUserId() { return userId; }
    public void setUserId(UserAccount userId) { this.userId = userId; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

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

    public PolicyRule getPolicyRule() { return policyRule; }
    public void setPolicyRule(PolicyRule policyRule) { this.policyRule = policyRule; }
}
