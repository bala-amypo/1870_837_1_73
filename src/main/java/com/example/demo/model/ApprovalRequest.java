package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "approval_requests")
public class ApprovalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestTitle;

    @Lob
    @Column(name = "request_payload_json", columnDefinition = "LONGTEXT")
    private String requestPayloadJson;

    private String status;
    private Integer currentLevel;
    private LocalDateTime createdAt;

    private Long requesterId;
    private Long templateId;

    // getters & setters
}
