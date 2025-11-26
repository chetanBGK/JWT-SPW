package com.fieldaudit.repo;

import com.fieldaudit.entity.Investigator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvestigatorRepository extends JpaRepository<Investigator, Long> {
}
