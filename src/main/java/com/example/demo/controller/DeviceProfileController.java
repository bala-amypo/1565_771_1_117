package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }


    @PostMapping
    public DeviceProfile registerDevice(@RequestBody DeviceProfile device) {
        return deviceService.registerDevice(device);
    }


    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrustStatus(
            @PathVariable Long id,
            @RequestParam boolean trust) {
        return deviceService.updateTrustStatus(id, trust);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getDevicesByUser(@PathVariable Long userId) {
        return deviceService.getDevicesByUser(userId);
    }

   
    @GetMapping("/lookup/{deviceId}")
    public DeviceProfile findByDeviceId(@PathVariable String deviceId) {
        return deviceService.findByDeviceId(deviceId);
    }
}
