package com.fieldaudit.service;

import com.fieldaudit.entity.AuditQuestion;

import java.util.List;
import java.util.UUID;

public interface AuditQuestionService {
    AuditQuestion save(AuditQuestion question);
    List<AuditQuestion> getByInvestigation(Long investigationId);
    List<AuditQuestion> getByInvestigationAndForm(Long investigationId, String formType);
}

