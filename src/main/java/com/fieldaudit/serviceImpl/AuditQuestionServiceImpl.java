package com.fieldaudit.serviceImpl;

import com.fieldaudit.entity.AuditQuestion;
import com.fieldaudit.entity.FieldInvestigation;
import com.fieldaudit.repo.AuditQuestionRepository;
import com.fieldaudit.repo.FieldInvestigationRepository;
import com.fieldaudit.service.AuditQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuditQuestionServiceImpl implements AuditQuestionService {

    @Autowired
    private AuditQuestionRepository repository;

    @Autowired
    private FieldInvestigationRepository invRepo;

    @Override
    public AuditQuestion save(AuditQuestion question) {
        return repository.save(question);
    }

    @Override
    public List<AuditQuestion> getByInvestigation(UUID investigationId) {
        FieldInvestigation inv = invRepo.findById(investigationId)
                .orElseThrow(() -> new RuntimeException("Investigation not found"));
        return repository.findByInvestigation(inv);
    }

    @Override
    public List<AuditQuestion> getByInvestigationAndForm(UUID investigationId, String formType) {
        FieldInvestigation inv = invRepo.findById(investigationId)
                .orElseThrow(() -> new RuntimeException("Investigation not found"));
        return repository.findByInvestigationAndAuditFormType(inv, formType);
    }
}

