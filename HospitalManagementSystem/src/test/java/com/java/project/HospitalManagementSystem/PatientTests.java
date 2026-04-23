package com.java.project.HospitalManagementSystem;

import com.java.project.HospitalManagementSystem.entity.Patient;
import com.java.project.HospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.BeforeAll; // Add this
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.TimeZone; // Add this

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @BeforeAll
    static void setup() {
        // This forces the JVM to use the 'Kolkata' ID before Spring/Hibernate starts
        System.setProperty("user.timezone", "Asia/Kolkata");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }

    @Test
    public void testPatientRepository(){
        List<Patient> patients = patientRepository.findAll();
        System.out.println(patients);
    }
}