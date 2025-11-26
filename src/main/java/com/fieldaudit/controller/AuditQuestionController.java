package com.fieldaudit.controller;

import com.fieldaudit.entity.AuditQuestion;
import com.fieldaudit.service.AuditQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<AuditQuestion> getByInvestigation(@PathVariable Long investigationId) {
        return auditQuestionService.getByInvestigation(investigationId);
    }

    @GetMapping("/{investigationId}/{formType}")
    public List<AuditQuestion> getByInvestigationAndForm(
            @PathVariable Long investigationId,
            @PathVariable String formType
    ) {
        return auditQuestionService.getByInvestigationAndForm(investigationId, formType);
    }
}

