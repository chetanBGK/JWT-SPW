package com.fieldaudit.service;

import com.fieldaudit.entity.Hospital;

import java.util.List;
import java.util.UUID;

public interface HospitalService {
    Hospital createHospital(Hospital hospital);
    Hospital getHospitalById(Long id);
    List<Hospital> getAllHospitals();
    Hospital updateHospital(Long id, Hospital hospital);
    void deleteHospital(Long id);
}

