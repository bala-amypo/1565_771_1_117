package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "device_profile")
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "user_id")
    private Long userId;

    private String deviceId;
    private String deviceType;
    private String osVersion;
    private Boolean isTrusted;
    private LocalDateTime lastSeen;

    public DeviceProfile() {}

    public DeviceProfile(Long userId, String deviceId, String deviceType, String osVersion, Boolean isTrusted) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.osVersion = osVersion;
        this.isTrusted = isTrusted;
        this.lastSeen = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long setUserId() { this.userId = userId; }
    public Long getUserId() { return userId; }
    public void setUser(UserAccount user) { this.user = user; }
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }
    public Boolean getIsTrusted() { return isTrusted; }
    public void setIsTrusted(Boolean trusted) { isTrusted = trusted; }
    public LocalDateTime getLastSeen() { return lastSeen; }
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }
}