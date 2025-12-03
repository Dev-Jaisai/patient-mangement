package com.pm.patientservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequestDTO {

    private String name;
    private String email;
    private String address;
    private String dateOfBirth;

    private String registeredDate;
}
