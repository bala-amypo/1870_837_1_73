package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class WorkflowStepConfig {

    @Id
    @GeneratedValue
    private Long id;

    // ⚠️ DO NOT USE RELATIONSHIP
    private Long templateId;

    private Integer levelNumber;
    private String approverRole;
    private Boolean isFinalStep;
    private String instructions;

    public Long getId() { return id; }

    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }

    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }

    public String getApproverRole() { return approverRole; }
    public void setApproverRole(String approverRole) { this.approverRole = approverRole; }

    public Boolean getIsFinalStep() { return isFinalStep; }
    public void setIsFinalStep(Boolean isFinalStep) { this.isFinalStep = isFinalStep; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}
