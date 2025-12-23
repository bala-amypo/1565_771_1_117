package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

public class ViolationRecordServiceImpl implements ViolationRecordService {

    ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository r) {
        repo = r;
    }

    public ViolationRecord logViolation(ViolationRecord v) {
        return repo.save(v);
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = repo.findById(id).orElse(null);
        v.setResolved(true);
        return repo.save(v);
    }
}
