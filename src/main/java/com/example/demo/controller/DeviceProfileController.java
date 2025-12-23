package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;

public class DeviceProfileController {

    DeviceProfileService svc;

    public DeviceProfileController(DeviceProfileService s) {
        svc = s;
    }

    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        return ResponseEntity.ok(svc.findByDeviceId(deviceId).orElse(null));
    }
}
