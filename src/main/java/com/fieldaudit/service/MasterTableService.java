package com.fieldaudit.service;

import com.fieldaudit.entity.MasterTable;

import java.util.List;
import java.util.UUID;

public interface MasterTableService {
    MasterTable create(MasterTable master);
    List<MasterTable> getByHospital(Long hospitalId);
}
