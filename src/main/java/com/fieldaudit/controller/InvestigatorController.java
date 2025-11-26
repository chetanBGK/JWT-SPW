package com.fieldaudit.controller;

import com.fieldaudit.entity.Investigator;
import com.fieldaudit.service.InvestigatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/investigators")
public class InvestigatorController {

    @Autowired
    private InvestigatorService investigatorService;

    @PostMapping
    public Investigator create(@RequestBody Investigator investigator) {
        return investigatorService.createInvestigator(investigator);
    }

    @GetMapping("/{id}")
    public Investigator getById(@PathVariable Long id) {
        return investigatorService.getInvestigatorById(id);
    }

    @GetMapping
    public List<Investigator> getAll() {
        return investigatorService.getAllInvestigators();
    }
}
