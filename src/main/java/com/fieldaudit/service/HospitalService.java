package com.fieldaudit.service;

import com.fieldaudit.entity.Hospital;

import java.util.List;
import java.util.UUID;

public interface HospitalService {
    Hospital createHospital(Hospital hospital);
    Hospital getHospitalById(UUID id);
    List<Hospital> getAllHospitals();
    Hospital updateHospital(UUID id, Hospital hospital);
    void deleteHospital(UUID id);
}

