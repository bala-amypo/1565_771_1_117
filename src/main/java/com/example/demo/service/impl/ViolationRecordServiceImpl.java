// package com.example.demo.service.impl;

// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.repository.ViolationRecordRepository;
// import com.example.demo.service.ViolationRecordService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class ViolationRecordServiceImpl implements ViolationRecordService {

//     private final ViolationRecordRepository repo;

//     public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
//         this.repo = repo;
//     }

//     public ViolationRecord logViolation(ViolationRecord violation) {
//         return repo.save(violation);
//     }

//     public List<ViolationRecord> getUnresolvedViolations() {
//         return repo.findByResolvedFalse();
//     }

//     public ViolationRecord markResolved(Long id) {
//         ViolationRecord v = repo.findById(id).orElseThrow();
//         v.setResolved(true);
//         return repo.save(v);
//     }
//     @Override
// public List<ViolationRecord> getViolationsByUser(Long userId) {
//     return repo.findAll()
//             .stream()
//             .filter(v -> v.getUserId().equals(userId))
//             .toList();
// }

// @Override
// public List<ViolationRecord> getAllViolations() {
//     return repo.findAll();
// }

// }
package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    public ViolationRecord logViolation(ViolationRecord violation) {
        return repo.save(violation);
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = repo.findById(id).orElseThrow();
        v.setResolved(true);
        return repo.save(v);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repo.findAll()
                .stream()
                .filter(v -> v.getUserId().equals(userId))
                .toList();
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repo.findAll();
    }
}
