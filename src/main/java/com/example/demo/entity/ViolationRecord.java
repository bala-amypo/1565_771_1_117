package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "violation_record")
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * USER RELATION (Entity Reference)
     * This keeps the OneToMany mapping intact
     */

    // RELATION FIELD (reads entity)
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
private UserAccount user;

// SHADOW FIELD (writes ID)
@AttributeOverride(name = "userId", column = @Column(name = "user_id"))
@Column(name = "user_id")
private Long user_Id;

    /**
     * Event FK
     */
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

    // -------------------- CONSTRUCTORS --------------------

    public ViolationRecord() {}

    public ViolationRecord(UserAccount user, Long eventId, PolicyRule policyRule,
                           String violationType, String details, String severity) {
        this.user = user;                // entity reference
        this.user_Id = user.getId();      // sync FK shadow field
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

    // Entity side
    public UserAccount getUser() { return user; }
    public void setUser(UserAccount user) {
        this.user = user;
        this.userId = (user != null ? user.getId() : null); // keep both in sync
    }

    // FK shadow field side (used by existing code)
    public Long getUserId() { return user_Id; }
    public void setUserId(Long userId) { this.user_Id = userId; }

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
