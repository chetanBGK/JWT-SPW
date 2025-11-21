package com.fieldaudit.controller;

import com.fieldaudit.entity.AuditQuestion;
import com.fieldaudit.service.AuditQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/audit-questions")
public class AuditQuestionController {

    @Autowired
    private AuditQuestionService auditQuestionService;

    @PostMapping
    public AuditQuestion save(@RequestBody AuditQuestion question) {
        return auditQuestionService.save(question);
    }

    @GetMapping("/investigation/{investigationId}")
    public List<AuditQuestion> getByInvestigation(@PathVariable UUID investigationId) {
        return auditQuestionService.getByInvestigation(investigationId);
    }

    @GetMapping("/{investigationId}/{formType}")
    public List<AuditQuestion> getByInvestigationAndForm(
            @PathVariable UUID investigationId,
            @PathVariable String formType
    ) {
        return auditQuestionService.getByInvestigationAndForm(investigationId, formType);
    }
}

