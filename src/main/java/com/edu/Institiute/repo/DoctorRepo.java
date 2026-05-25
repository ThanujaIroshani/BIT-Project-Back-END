package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {

    @Query(value = "SELECT * FROM doctor WHERE doctorId=:doctorId", nativeQuery = true)
    Doctor findByDocId(@Param("doctorId") String doctorId);


    @Query(value = "SELECT * FROM doctor WHERE doctorId=:doctorId", nativeQuery = true)
    Doctor getDoctorById (@Param("doctorId")String doctorId);
}
