package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // FIX: Added missing import
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    @Autowired
    private DeviceProfileService deviceProfileService; 

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getDevices(@PathVariable Long userId) {
        return ResponseEntity.ok(deviceProfileService.getDeviceByUser(userId));
    }
}