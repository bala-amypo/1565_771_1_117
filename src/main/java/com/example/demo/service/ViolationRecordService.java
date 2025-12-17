package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ViolationRecord;


















public interface ViolationRecordService{
    ViolationRecord logViolation(ViolationRecord violation);
    List<ViolationRecord> getViolationsByUser(Long userId);
    ViolationRecord markResolved(Long id);
    List<ViolationRecord> getUnResolvedViolations();
    List<ViolationRecord> getAllViolations();
}