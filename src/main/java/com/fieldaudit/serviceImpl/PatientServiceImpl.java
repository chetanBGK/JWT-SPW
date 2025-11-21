package com.fieldaudit.serviceImpl;

import com.fieldaudit.entity.Hospital;
import com.fieldaudit.entity.Patient;
import com.fieldaudit.repo.HospitalRepository;
import com.fieldaudit.repo.PatientRepository;
import com.fieldaudit.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(UUID id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> getPatientsByHospital(UUID hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));
        return patientRepository.findByHospital(hospital);
    }

    @Override
    public Patient updatePatient(UUID id, Patient patient) {
        Patient existing = getPatientById(id);
        existing.setPatientName(patient.getPatientName());
        return patientRepository.save(existing);
    }

    @Override
    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}
