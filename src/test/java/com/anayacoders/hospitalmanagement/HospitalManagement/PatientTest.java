package com.anayacoders.hospitalmanagement.HospitalManagement;

import com.anayacoders.hospitalmanagement.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.anayacoders.hospitalmanagement.HospitalManagement.entity.Patient;
import com.anayacoders.hospitalmanagement.HospitalManagement.entity.type.BloodGroupType;
import com.anayacoders.hospitalmanagement.HospitalManagement.repository.PatientRepository;
import com.anayacoders.hospitalmanagement.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods() {
//        Patient patient = patientService.getPatientById(1L);
//        Patient patient = patientRepository.findByName("Diya Patel");
//        List<Patient> patient = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 3, 15), "neha.iyer@example.com");
//        List<Patient> patient = patientRepository.findByEmailContaining("example");
//        List<Patient> patient = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        List<Patient> patient = patientRepository.findByBornAfterDate(LocalDate.of(1993,3,15));
//        patient.forEach(System.out::println);
//        List<Object[]> bloodGroups = patientRepository.countEachBloodGroupType();
//        for (Object[] objects: bloodGroups){
//            System.out.println(objects[0]+" "+objects[1]);
//        }
//        List<BloodGroupCountResponseEntity> bloodGroups = patientRepository.countEachBloodGroupType();
//        System.out.println(bloodGroups);

//        List<Patient> patientList = patientRepository.findAllPatient();
//        System.out.println(patientList);

//        int rowUpdated = patientRepository.updateNameWithId("Arav Sharma", 1L);
//        System.out.println(rowUpdated);

        Page<Patient> patientPage = patientRepository.findAllPatientPagination(PageRequest.of(1,2, Sort.by("name", "birthDate")));
        patientPage.forEach(System.out::println);

    }


}
