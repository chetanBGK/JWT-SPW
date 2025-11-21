package com.fieldaudit.repo;

import com.fieldaudit.entity.Hospital;
import com.fieldaudit.entity.MasterTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MasterTableRepository extends JpaRepository<MasterTable, UUID> {

    List<MasterTable> findByHospital(Hospital hospital);
}
