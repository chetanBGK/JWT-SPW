package com.fieldaudit.controller;

import com.fieldaudit.entity.Patient;
import com.fieldaudit.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAllPatients();
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<Patient> getByHospital(@PathVariable Long hospitalId) {
        return patientService.getPatientsByHospital(hospitalId);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}

