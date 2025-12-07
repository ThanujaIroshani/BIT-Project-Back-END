package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table (name = "doctor")
public class Doctor {

    @Id
    @Column(name="doctorID")
    private String doctorID;

    @Column(name = "UserId")
    private String UserId;

    @Column(name = "Specializations")
    private String Specializations;

    @Column(name="Qualifications")
    private String Qualifications;

    @Column(name = "LicenceNumber")
    private String LicenceNumber;

    @Column(name = "YearsOfExperience")
    private Integer YearsOfExperience;

    @Column(name = "IsActive")
    private Boolean IsActive;

    @Column(name = "CreatedBy")
    private String CreatedBy;

    @Column(name = "CreatedDate")
    private Date CreatedDate;

    @Column(name = "ModifiedBy")
    private String ModifiedBy;

    @Column(name = "ModifiedDate")
    private Date ModifiedDate;
}
