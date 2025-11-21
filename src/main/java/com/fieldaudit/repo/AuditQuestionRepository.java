package com.fieldaudit.repo;

import com.fieldaudit.entity.AuditQuestion;
import com.fieldaudit.entity.FieldInvestigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuditQuestionRepository extends JpaRepository<AuditQuestion, UUID> {

    List<AuditQuestion> findByInvestigation(FieldInvestigation investigation);

    List<AuditQuestion> findByInvestigationAndAuditFormType(
            FieldInvestigation investigation,
            String auditFormType
    );
}

