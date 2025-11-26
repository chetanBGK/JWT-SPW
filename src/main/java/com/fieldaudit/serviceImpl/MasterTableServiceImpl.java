package com.fieldaudit.serviceImpl;

import com.fieldaudit.entity.Hospital;
import com.fieldaudit.entity.MasterTable;
import com.fieldaudit.repo.HospitalRepository;
import com.fieldaudit.repo.MasterTableRepository;
import com.fieldaudit.service.MasterTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MasterTableServiceImpl implements MasterTableService {

    @Autowired
    private MasterTableRepository repository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public MasterTable create(MasterTable master) {
        return repository.save(master);
    }

    @Override
    public List<MasterTable> getByHospital(Long hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));
        return repository.findByHospital(hospital);
    }
}

