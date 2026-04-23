package com.java.project.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;
    private String gender;
    private String email;
}


