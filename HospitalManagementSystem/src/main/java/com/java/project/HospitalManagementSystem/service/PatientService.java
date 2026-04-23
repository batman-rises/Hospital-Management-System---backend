package com.java.project.HospitalManagementSystem.service;

import com.java.project.HospitalManagementSystem.entity.Patient;
import com.java.project.HospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    public Patient getPatientById(Long id){
        Patient p1=patientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id not found"));
        return p1;
    }
}
