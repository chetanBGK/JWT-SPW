package com.fieldaudit.repo;

import com.fieldaudit.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}