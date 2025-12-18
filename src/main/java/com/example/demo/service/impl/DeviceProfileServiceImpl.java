package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private List<DeviceProfile> devices = new ArrayList<>();
    private long idCounter = 1; // Renamed to avoid confusion with method parameters

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setId(idCounter++);
        devices.add(device);
        return device;
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        for (DeviceProfile d : devices) {
            // FIX: Use == instead of .equals() for primitives, 
            // or ensure both sides are Objects.
            if (d.getId() == id) { 
                d.setIsTrusted(trust);
                return d;
            }
        }
        return null;
    }

    @Override
    public List<DeviceProfile> getDeviceByUser(Long userId) {
        List<DeviceProfile> result = new ArrayList<>();
        for (DeviceProfile d : devices) {
            // FIX: Use == to compare primitive long to Long wrapper
            if (d.getUserId() == userId) {
                result.add(d);
            }
        }
        return result;
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        for (DeviceProfile d : devices) {
            // String is an Object, so .equals() is correct here
            if (d.getDeviceId().equals(deviceId)) {
                return d;
            }
        }
        return null;
    }
}