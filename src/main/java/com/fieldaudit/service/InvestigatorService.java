package com.fieldaudit.service;

import com.fieldaudit.entity.Investigator;

import java.util.List;
import java.util.UUID;

public interface InvestigatorService {
    Investigator createInvestigator(Investigator investigator);
    Investigator getInvestigatorById(UUID id);
    List<Investigator> getAllInvestigators();
}

