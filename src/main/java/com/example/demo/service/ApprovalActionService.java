package com.example.demo.service;

import com.example.demo.model.ApprovalAction;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionService {

    private final ApprovalActionRepository actionRepo;
    private final ApprovalRequestRepository requestRepo;

    // ⚠️ EXACT ORDER
    public ApprovalActionService(
            ApprovalActionRepository actionRepo,
            ApprovalRequestRepository requestRepo) {
        this.actionRepo = actionRepo;
        this.requestRepo = requestRepo;
    }

    public ApprovalAction recordAction(ApprovalAction action) {

        ApprovalRequest request =
                requestRepo.findById(action.getRequestId()).orElse(null);

        if (request != null) {
            if ("APPROVED".equals(action.getAction())) {
                request.setCurrentLevel(request.getCurrentLevel() + 1);
            } else {
                request.setStatus("REJECTED");
            }
            requestRepo.save(request);
        }
        return actionRepo.save(action);
    }
}
