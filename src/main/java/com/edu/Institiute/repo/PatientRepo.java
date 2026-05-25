package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
