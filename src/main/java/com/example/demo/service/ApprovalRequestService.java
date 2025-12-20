package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalRequestService {

    private final ApprovalRequestRepository requestRepo;
    private final WorkflowStepConfigRepository stepRepo;
    private final WorkflowTemplateRepository templateRepo;
    private final ApprovalActionRepository actionRepo;

    // ⚠️ EXACT ORDER
    public ApprovalRequestService(
            ApprovalRequestRepository requestRepo,
            WorkflowStepConfigRepository stepRepo,
            WorkflowTemplateRepository templateRepo,
            ApprovalActionRepository actionRepo) {

        this.requestRepo = requestRepo;
        this.stepRepo = stepRepo;
        this.templateRepo = templateRepo;
        this.actionRepo = actionRepo;
    }

    public ApprovalRequest createRequest(ApprovalRequest req) {
        req.setStatus("PENDING");
        req.setCurrentLevel(1);
        return requestRepo.save(req);
    }

    public List<ApprovalRequest> getRequestsByRequester(Long userId) {
        return requestRepo.findByRequesterId(userId);
    }

    public List<ApprovalRequest> getAllRequests() {
        return requestRepo.findAll();
    }
}
