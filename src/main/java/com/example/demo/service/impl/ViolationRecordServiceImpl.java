package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.entity.ViolationRecord;
import com.example.demo1.service.ViolationRecordService;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    List<ViolationRecord> violations = new ArrayList<>();
    long id = 1;

    @Override
    public ViolationRecord logViolation(ViolationRecord violation) {
        violation.setId(id++);
        violations.add(violation);
        return violation;
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        List<ViolationRecord> result = new ArrayList<>();
        for (ViolationRecord v : violations) {
            if (v.getUserId()==userId) {
                result.add(v);
            }
        }
        return result;
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        for (ViolationRecord v : violations) {
            if (v.getId()==id) {
                v.setResolved(true);
                return v;
            }
        }
        return null;
    }

    @Override
    public List<ViolationRecord> getUnResolvedViolations() {
        List<ViolationRecord> result = new ArrayList<>();
        for (ViolationRecord v : violations) {
            if (!v.getResolved()) {
                result.add(v);
            }
        }
        return result;
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return violations;
    }
}
