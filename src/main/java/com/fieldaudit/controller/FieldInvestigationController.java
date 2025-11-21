package com.fieldaudit.controller;

import com.fieldaudit.entity.FieldInvestigation;
import com.fieldaudit.service.FieldInvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/investigations")
public class FieldInvestigationController {

    @Autowired
    private FieldInvestigationService investigationService;

    @PostMapping
    public FieldInvestigation create(@RequestBody FieldInvestigation investigation) {
        return investigationService.create(investigation);
    }

    @GetMapping("/{id}")
    public FieldInvestigation getById(@PathVariable UUID id) {
        return investigationService.getById(id);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<FieldInvestigation> getByHospital(@PathVariable UUID hospitalId) {
        return investigationService.getByHospital(hospitalId);
    }

    @GetMapping("/investigator/{investigatorId}")
    public List<FieldInvestigation> getByInvestigator(@PathVariable UUID investigatorId) {
        return investigationService.getByInvestigator(investigatorId);
    }
}

