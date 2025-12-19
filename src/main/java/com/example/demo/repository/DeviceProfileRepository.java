package com.example.demo.repository;

import com.example.demo.entity.DeviceProfile;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceProfileRepository {
    public DeviceProfile findByName(String name) {
        DeviceProfile d = new DeviceProfile();
        d.setName(name);
        return d;
    }
}
