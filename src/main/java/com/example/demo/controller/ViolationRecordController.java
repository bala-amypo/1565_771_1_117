package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;

public class ViolationRecordController {

    ViolationRecordService svc;

    public ViolationRecordController(ViolationRecordService s) {
        svc = s;
    }

    public ResponseEntity<ViolationRecord> log(ViolationRecord v) {
        return ResponseEntity.ok(svc.logViolation(v));
    }
}
