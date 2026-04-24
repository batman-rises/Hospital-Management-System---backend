package com.java.project.HospitalManagementSystem.repository;

import com.java.project.HospitalManagementSystem.entity.Patient;
import com.java.project.HospitalManagementSystem.entity.type.BloodGroupType;
import org.springframework.data.domain.Page; // Corrected import
import org.springframework.data.domain.Pageable; // Corrected import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    // Fixed: Using named parameter :bloodGroup to match @Param
    @Query("SELECT p FROM Patient p where p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    // Fixed: Native query works best with Spring's Page and Pageable
    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);
}