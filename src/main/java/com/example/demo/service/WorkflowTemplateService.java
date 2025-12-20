package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    // ⚠️ EXACT ORDER
    public WorkflowTemplateService(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
        return repository.save(t);
    }

    public WorkflowTemplate getTemplateById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<WorkflowTemplate> getAllTemplates() {
        return repository.findAll();
    }

    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        t.setActive(true);
        return repository.save(t);
    }

    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate t = repository.findById(id).orElse(null);
        if (t != null) {
            t.setActive(active);
            return repository.save(t);
        }
        return null;
    }
}
