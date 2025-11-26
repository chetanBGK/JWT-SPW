package com.fieldaudit.service;

import com.fieldaudit.entity.FieldInvestigation;

import java.util.List;
import java.util.UUID;

public interface FieldInvestigationService {
    FieldInvestigation create(FieldInvestigation investigation);
    FieldInvestigation getById(Long id);
    List<FieldInvestigation> getByHospital(Long hospitalId);
    List<FieldInvestigation> getByInvestigator(Long investigatorId);
}

