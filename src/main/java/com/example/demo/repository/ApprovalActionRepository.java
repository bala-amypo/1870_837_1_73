package com.example.demo.repository;

import com.example.demo.model.ApprovalAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApprovalActionRepository
        extends JpaRepository<ApprovalAction, Long> {

    @Query("""
           SELECT a
           FROM ApprovalAction a
           WHERE a.levelNumber = :level
             AND a.action = :action
           """)
    List<ApprovalAction> findByLevelAndAction(
            @Param("level") Integer level,
            @Param("action") String action
    );
}
