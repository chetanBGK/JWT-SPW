package com.fieldaudit.service;

import com.fieldaudit.entity.Doctor;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    Doctor getDoctorById(UUID id);
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsByHospital(UUID hospitalId);
    Doctor updateDoctor(UUID id, Doctor doctor);
    void deleteDoctor(UUID id);
}

