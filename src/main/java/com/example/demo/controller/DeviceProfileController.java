package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    @Autowired
    DeviceProfileService deviceProfileService;

    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        return ResponseEntity.status(201)
                .body(deviceProfileService.registerDevice(device));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceProfile> updateTrustStatus(@PathVariable Long id,
                                                           @RequestParam boolean trust) {
        return ResponseEntity.status(200)
                .body(deviceProfileService.updateTrustStatus(id, trust));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getDeviceByUser(@PathVariable Long userId) {
        return ResponseEntity.status(200)
                .body(deviceProfileService.getDeviceByUser(userId));
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceProfile> findByDeviceId(@PathVariable String deviceId) {
        return ResponseEntity.status(200)
                .body(deviceProfileService.findByDeviceId(deviceId));
    }
}
