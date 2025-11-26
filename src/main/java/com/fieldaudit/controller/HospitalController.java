package com.fieldaudit.controller;

import com.fieldaudit.entity.Hospital;
import com.fieldaudit.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public Hospital create(@RequestBody Hospital hospital) {
        return hospitalService.createHospital(hospital);
    }

    @GetMapping("/{id}")
    public Hospital getById(@PathVariable Long id) {
        return hospitalService.getHospitalById(id);
    }

    @GetMapping
    public List<Hospital> getAll() {
        return hospitalService.getAllHospitals();
    }

    @PutMapping("/{id}")
    public Hospital update(@PathVariable Long id, @RequestBody Hospital hospital) {
        return hospitalService.updateHospital(id, hospital);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
    }
}

