package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    public DeviceProfile registerDevice(DeviceProfile device) {
        return repo.save(device);
    }

    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile d = repo.findById(id).orElseThrow();
        d.setIsTrusted(trust);
        return repo.save(d);
    }

    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repo.findAll();
    }

    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }
}
