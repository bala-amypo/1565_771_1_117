package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setLastSeen(LocalDateTime.now());
        device.setIsTrusted(true);
        return repository.save(device);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trusted) {
        DeviceProfile device = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setIsTrusted(trusted);
        return repository.save(device);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public DeviceProfile getByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }
}
