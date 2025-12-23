package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.ViolationRecord;

public interface ViolationRecordRepository {
    ViolationRecord save(ViolationRecord v);
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findByResolvedFalse();
    List<ViolationRecord> findByUserId(Long userId);
    List<ViolationRecord> findAll();
}
