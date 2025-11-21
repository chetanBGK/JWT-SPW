package com.fieldaudit.serviceImpl;

import com.fieldaudit.entity.FieldInvestigation;
import com.fieldaudit.entity.Hospital;
import com.fieldaudit.entity.Investigator;
import com.fieldaudit.repo.FieldInvestigationRepository;
import com.fieldaudit.repo.HospitalRepository;
import com.fieldaudit.repo.InvestigatorRepository;
import com.fieldaudit.service.FieldInvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FieldInvestigationServiceImpl implements FieldInvestigationService {

    @Autowired
    private FieldInvestigationRepository repository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private InvestigatorRepository investigatorRepository;

    @Override
    public FieldInvestigation create(FieldInvestigation investigation) {
        return repository.save(investigation);
    }

    @Override
    public FieldInvestigation getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investigation not found"));
    }

    @Override
    public List<FieldInvestigation> getByHospital(UUID hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));
        return repository.findByHospital(hospital);
    }

    @Override
    public List<FieldInvestigation> getByInvestigator(UUID investigatorId) {
        Investigator inv = investigatorRepository.findById(investigatorId)
                .orElseThrow(() -> new RuntimeException("Investigator not found"));
        return repository.findByInvestigator(inv);
    }
}

