package com.fieldaudit.repo;

import com.fieldaudit.entity.Doctor;
import com.fieldaudit.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    List<Doctor> findByHospital(Hospital hospital);
}
