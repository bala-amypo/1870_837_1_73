package com.example.demo.service;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repository;

    // ⚠️ EXACT ORDER
    public WorkflowStepConfigService(WorkflowStepConfigRepository repository) {
        this.repository = repository;
    }

    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return repository.save(step);
    }

    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        return repository.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
