package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository actionRepository;
    private final ApprovalRequestRepository requestRepository;

    public ApprovalActionServiceImpl(
            ApprovalActionRepository actionRepository,
            ApprovalRequestRepository requestRepository
    ) {
        this.actionRepository = actionRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public ApprovalAction recordAction(ApprovalAction action) {
        return actionRepository.save(action);
    }
}
