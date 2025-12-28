// package com.example.demo.service.impl;

// import com.example.demo.entity.DeviceProfile;
// import com.example.demo.repository.DeviceProfileRepository;
// import com.example.demo.service.DeviceProfileService;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class DeviceProfileServiceImpl implements DeviceProfileService {

//     private final DeviceProfileRepository repository;

//     public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public DeviceProfile registerDevice(DeviceProfile device) {
//         device.setLastSeen(LocalDateTime.now());
//         device.setIsTrusted(true);
//         return repository.save(device);
//     }

//     @Override
//     public DeviceProfile updateTrustStatus(Long id, boolean trusted) {
//         // Change: Use ResponseStatusException for proper 404 status
//         DeviceProfile device = repository.findById(id)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found with ID: " + id));
        
//         device.setIsTrusted(trusted); // Use the variable instead of hardcoded 'false'
//         return repository.save(device);
//     }

//     @Override
//     public List<DeviceProfile> getDevicesByUser(Long userId) {
//         return repository.findByUserId(userId);
//     }

//     @Override
//     public DeviceProfile getByDeviceId(String deviceId) {
//         // Change: Use ResponseStatusException for proper 404 status
//         return repository.findByDeviceId(deviceId)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found with deviceId: " + deviceId));
//     }
// }
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
