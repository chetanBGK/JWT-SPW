package com.fieldaudit.controller;

import com.fieldaudit.entity.FieldInvestigation;
import com.fieldaudit.service.FieldInvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public FieldInvestigation getById(@PathVariable Long id) {
        return investigationService.getById(id);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<FieldInvestigation> getByHospital(@PathVariable Long hospitalId) {
        return investigationService.getByHospital(hospitalId);
    }

    @GetMapping("/investigator/{investigatorId}")
    public List<FieldInvestigation> getByInvestigator(@PathVariable Long investigatorId) {
        return investigationService.getByInvestigator(investigatorId);
    }
}

