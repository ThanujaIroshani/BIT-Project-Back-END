package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
public class Doctor {

    @Id
    @Column(name = "doctorId")
    private String doctorId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "specializations")
    private String specializations;

    @Column(name = "qualifications")
    private String qualifications;

    @Column (name = "licenseNumber")
    private String licenseNumber;

    @Column (name = "yearsOfExperience")
    private int yearsOfExperience;

    @Column (name = "isActive")
    private boolean isActive;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "modifiedDate")
    private Date modifiedDate;

    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName = "id")
    private Status status;
}
