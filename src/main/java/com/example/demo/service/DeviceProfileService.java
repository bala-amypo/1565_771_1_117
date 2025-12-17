package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    DeviceProfile updateTrustStatus(Long id, boolean trust);

    List<DeviceProfile> getDeviceByUser(Long userId);

    DeviceProfile findByDeviceId(String deviceId);
}
