package com.fieldaudit.service;

import com.fieldaudit.entity.FieldInvestigation;

import java.util.List;
import java.util.UUID;

public interface FieldInvestigationService {
    FieldInvestigation create(FieldInvestigation investigation);
    FieldInvestigation getById(UUID id);
    List<FieldInvestigation> getByHospital(UUID hospitalId);
    List<FieldInvestigation> getByInvestigator(UUID investigatorId);
}

