package com.fieldaudit.controller;

import com.fieldaudit.entity.MasterTable;
import com.fieldaudit.service.MasterTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/master-data")
public class MasterTableController {

    @Autowired
    private MasterTableService masterTableService;

    @PostMapping
    public MasterTable create(@RequestBody MasterTable masterTable) {
        return masterTableService.create(masterTable);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<MasterTable> getByHospital(@PathVariable Long hospitalId) {
        return masterTableService.getByHospital(hospitalId);
    }
}
