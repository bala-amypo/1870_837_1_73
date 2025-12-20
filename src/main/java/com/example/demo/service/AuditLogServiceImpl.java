package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRecordRepository auditLogRecordRepository;

    // Constructor injection (tests rely on this)
    public AuditLogServiceImpl(AuditLogRecordRepository auditLogRecordRepository) {
        this.auditLogRecordRepository = auditLogRecordRepository;
    }

    @Override
    public AuditLogRecord logEvent(AuditLogRecord record) {
        return auditLogRecordRepository.save(record);
    }
}
