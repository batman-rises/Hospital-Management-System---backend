package com.java.project.HospitalManagementSystem.repository;

import com.java.project.HospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
