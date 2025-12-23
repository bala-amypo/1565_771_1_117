package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

public class DeviceProfileServiceImpl implements DeviceProfileService {

    DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository r) {
        repo = r;
    }

    public DeviceProfile registerDevice(DeviceProfile d) {
        return repo.save(d);
    }

    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile d = repo.findById(id).orElse(null);
        d.setIsTrusted(trust);
        return repo.save(d);
    }

    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }
}
