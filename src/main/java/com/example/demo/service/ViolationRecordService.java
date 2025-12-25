package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {

    ViolationRecord logViolation(ViolationRecord violation);

    List<ViolationRecord> getViolationsByUser(Long userId);

    List<ViolationRecord> getAllViolations();

    List<ViolationRecord> getUnresolvedViolations();

    ViolationRecord markResolved(Long id);
}
