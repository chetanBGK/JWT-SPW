package com.fieldaudit.repo;

import com.fieldaudit.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FieldInvestigationRepository extends JpaRepository<FieldInvestigation, UUID> {

    List<FieldInvestigation> findByHospital(Hospital hospital);

    List<FieldInvestigation> findByInvestigator(Investigator investigator);

    List<FieldInvestigation> findByPatient(Patient patient);

    List<FieldInvestigation> findByDoctor(Doctor doctor);
}

