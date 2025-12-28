package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> trust(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateTrustStatus(id, true));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getDevicesByUser(userId));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> getByDevice(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

// package com.example.demo.controller;

// import com.example.demo.entity.*;
// import com.example.demo.service.*;
// import org.springframework.http.*;

// public class DeviceProfileController {
//     private final DeviceProfileService service;
//     public DeviceProfileController(DeviceProfileService service) {
//         this.service = service;
//     }
//     public ResponseEntity<DeviceProfile> lookup(String id) {
//         return ResponseEntity.ok(service.findByDeviceId(id).orElse(null));
//     }
// }

