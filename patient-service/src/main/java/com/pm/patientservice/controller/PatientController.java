package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {


   private final PatientService patientService;

    @GetMapping("/getPatients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {

        List<PatientResponseDTO> patients = patientService.getPatients();

        return ResponseEntity.ok(patients);
    }


    @PostMapping("/addPatient")
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.addPatient(patientRequestDTO);

        return new ResponseEntity<>(patientResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/addPatient")
    public ResponseEntity<PatientResponseDTO> addPatient1(@RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.addPatient(patientRequestDTO);
        System.out.println("Hi ");
       syso
        return new ResponseEntity<>(patientResponseDTO, HttpStatus.CREATED);
    }
}
