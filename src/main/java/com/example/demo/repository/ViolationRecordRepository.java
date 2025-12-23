package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordRepository {
    ViolationRecord save(ViolationRecord v);
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findByResolvedFalse();
    List<ViolationRecord> findByUserId(Long userId);
    List<ViolationRecord> findAll();
}
