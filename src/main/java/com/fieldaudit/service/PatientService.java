package com.fieldaudit.service;

import com.fieldaudit.entity.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    List<Patient> getPatientsByHospital(Long hospitalId);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}

