package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    List<DeviceProfile> devices = new ArrayList<>();
    long id = 1;

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setId(id++);
        device.setLastSeen(LocalDateTime.now());
        device.setIsTrusted(false);
        devices.add(device);
        return device;
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        for (DeviceProfile d : devices) {
            if (d.getId()==(id)) {
                d.setIsTrusted(trust);
                return d;
            }
        }
        return null;
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        List<DeviceProfile> result = new ArrayList<>();
        for (DeviceProfile d : devices) {
            if (d.getUserId()==(userId)) {
                result.add(d);
            }
        }
        return result;
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        for (DeviceProfile d : devices) {
            if (d.getDeviceId().equals(deviceId)) {
                return d;
            }
        }
        return null;
    }
}
