package com.fieldaudit.serviceImpl;

import com.fieldaudit.entity.Investigator;
import com.fieldaudit.repo.InvestigatorRepository;
import com.fieldaudit.service.InvestigatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvestigatorServiceImpl implements InvestigatorService {

    @Autowired
    private InvestigatorRepository investigatorRepository;

    @Override
    public Investigator createInvestigator(Investigator investigator) {
        return investigatorRepository.save(investigator);
    }

    @Override
    public Investigator getInvestigatorById(Long id) {
        return investigatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investigator not found"));
    }

    @Override
    public List<Investigator> getAllInvestigators() {
        return investigatorRepository.findAll();
    }
}

