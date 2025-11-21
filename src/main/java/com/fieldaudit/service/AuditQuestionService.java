package com.fieldaudit.service;

import com.fieldaudit.entity.AuditQuestion;

import java.util.List;
import java.util.UUID;

public interface AuditQuestionService {
    AuditQuestion save(AuditQuestion question);
    List<AuditQuestion> getByInvestigation(UUID investigationId);
    List<AuditQuestion> getByInvestigationAndForm(UUID investigationId, String formType);
}

