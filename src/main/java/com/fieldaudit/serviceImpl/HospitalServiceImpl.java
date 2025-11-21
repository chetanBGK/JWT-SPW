package com.fieldaudit.serviceImpl;

import com.fieldaudit.entity.Hospital;
import com.fieldaudit.repo.HospitalRepository;
import com.fieldaudit.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital createHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital getHospitalById(UUID id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital updateHospital(UUID id, Hospital hospital) {
        Hospital existing = getHospitalById(id);
        existing.setHospitalName(hospital.getHospitalName());
        existing.setHospitalAddress(hospital.getHospitalAddress());
        existing.setDistrict(hospital.getDistrict());
        existing.setState(hospital.getState());
        return hospitalRepository.save(existing);
    }

    @Override
    public void deleteHospital(UUID id) {
        hospitalRepository.deleteById(id);
    }
}

