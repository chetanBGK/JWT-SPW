package com.fieldaudit.service;

import com.fieldaudit.entity.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(UUID id);
    List<Patient> getAllPatients();
    List<Patient> getPatientsByHospital(UUID hospitalId);
    Patient updatePatient(UUID id, Patient patient);
    void deletePatient(UUID id);
}

