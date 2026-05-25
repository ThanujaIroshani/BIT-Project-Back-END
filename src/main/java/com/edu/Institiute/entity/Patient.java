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
@Table(name="Patient")
public class Patient {

    @Id
    @Column(name = "patientId")
    private String patientId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "bloodGroup")
    private String bloodGroup;

    @Column(name = "emergencyContactName")
    private String emergencyContactName;

    @Column(name = "emergencyContactNumber")
    private String emergencyContactNumber;

    @Column(name = "medicalHistoryNotes")
    private String medicalHistoryNotes;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "modifiedDate")
    private Date modifiedDate;

}