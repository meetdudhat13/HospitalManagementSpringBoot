package com.anayacoders.hospitalmanagement.HospitalManagement.service;

import com.anayacoders.hospitalmanagement.HospitalManagement.entity.Patient;
import com.anayacoders.hospitalmanagement.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
//        Patient p1 = patientRepository.findById(id).orElseThrow();
//        Patient p2 = patientRepository.findById(id).orElseThrow();
//        System.out.println(p2==p1);

//        p1.setName("Money Money");

//        No need to write below line because we are in transactional context so it update automatically in database,
//        if it runs successfully the whole method
//        patientRepository.save(p1)
        return new Patient();
    }
}
