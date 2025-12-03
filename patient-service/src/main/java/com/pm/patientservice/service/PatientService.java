package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {


    private final PatientRepository patientRepository;


    public List<PatientResponseDTO> getPatients() {

        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientList = patients.stream().map(PatientMapper::toDto).toList();
        //patients.stream.map(patient->PatientMapper.toDto(patient)).toList();
        return patientList;
    }

    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {

        Patient patient = PatientMapper.toEntity(patientRequestDTO);
        Patient savedPatient = patientRepository.save(patient);
        PatientResponseDTO patientResponseDTO = PatientMapper.toDto(savedPatient);


        return patientResponseDTO;


    }
}
