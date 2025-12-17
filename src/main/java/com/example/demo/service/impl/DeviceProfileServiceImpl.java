package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {
    List<DeviceProfile> devices=new ArrayList<>();
    long id;

    public DeviceProfile registerDevice(DeviceProfile device){
        device.setId(id++);
        devices.add(device);
        return device;
    }
    public DeviceProfile updateTrustStatus(Long id, boolean trust){
        for(DeviceProfile d : devices){
            if(d.getId()==id){
                d.setIsTrusted(trust);
                return d;
            }
        }
        return null;
    }
    public List<DeviceProfile> getDeviceByUser(Long userId){
        List<DeviceProfile> result = new ArrayList<>();
        for(DeviceProfile d : devices){
            if(d.getUserId()==userId){
                result.add(d);
            }
        }
        return result;
    }
    public DeviceProfile findByDeviceId(String deviceId){
        for(DeviceProfile d: devices){
            if(d.getDeviceId().equals(deviceId)){
                return d;
            }
        }
        return null;
    }
}
