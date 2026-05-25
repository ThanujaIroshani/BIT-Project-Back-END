package com.edu.Institiute.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Integer patientId;
    private Integer userId;
    private String bloodGroup;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String medicalHistoryNotes;
    private Boolean isActive;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;


}
