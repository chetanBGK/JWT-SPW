package com.fieldaudit.service;

import com.fieldaudit.entity.Doctor;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsByHospital(Long hospitalId);
    Doctor updateDoctor(Long id, Doctor doctor);
    void deleteDoctor(Long id);
}

