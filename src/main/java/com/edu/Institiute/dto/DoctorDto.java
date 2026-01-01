package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private String doctorId;
    private String userId;
    private String specializations;
    private String qualifications;
    private String licenceNumber;
    private Integer yearsOfExperience;
    private Boolean isActive;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

}
