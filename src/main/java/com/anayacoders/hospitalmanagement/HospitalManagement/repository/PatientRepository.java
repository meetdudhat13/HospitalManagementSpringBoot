package com.anayacoders.hospitalmanagement.HospitalManagement.repository;

import com.anayacoders.hospitalmanagement.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.anayacoders.hospitalmanagement.HospitalManagement.entity.Patient;
import com.anayacoders.hospitalmanagement.HospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    //    TODO: Below methods are implemented by JPA, no need to implement it (Just Follow Naming Convention)
    Patient findByName(String name);

    Patient findByBirthDate(LocalDate date);

    List<Patient> findByBirthDateOrEmail(LocalDate date, String email);

    List<Patient> findByNameContaining(String query);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    List<Patient> findByEmailContaining(String query);

//    TODO: Writing Custom Query

    //    Use Param String in Sql query using order of variable(starting from 1 onwards)
    @Query("SELECT p from Patient p WHERE p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

//*****************************************************************************************************************

    //    Use Param String in Sql query using colon(:varName)
    @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

//*****************************************************************************************************************

    //    Custom groupBy query - Both queries are same
//    @Query("SELECT p.bloodGroup, Count(p) FROM Patient p GROUP BY p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();

    //Below method is called as projection in query by which we can convert the output into objects(projection can't be use with native query)
    //Whenever the nativeQuery = true - we can't use projection in it
    @Query("SELECT new com.anayacoders.hospitalmanagement.HospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, Count(p)) FROM Patient p GROUP BY p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();


//*****************************************************************************************************************

    //    Write row sql query (native sql)
    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    List<Patient> findAllPatient();

//*****************************************************************************************************************

    //    Update particular field by id
    @Transactional
    @Modifying
    //This annotation is used to manage transactional things while updating database(prevent multiple updates at a time)
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

//*****************************************************************************************************************

    //    Pagination in response
    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    Page<Patient> findAllPatientPagination(Pageable pageable);

//*****************************************************************************************************************

}
