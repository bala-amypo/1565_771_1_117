package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile d) {
        return ResponseEntity.ok(service.registerDevice(d));
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> trust(
            @PathVariable Long id,
            @RequestParam boolean trusted) {
        return ResponseEntity.ok(service.updateTrustStatus(id, trusted));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getDevicesByUser(userId));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        Optional<DeviceProfile> d = service.findByDeviceId(deviceId);
        return ResponseEntity.ok(d.orElse(null));
    }
}
