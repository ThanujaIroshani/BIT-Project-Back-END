package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDto {

    private String doctorId;
    private Integer userId;
    private String specializations;
    private String qualifications;
    private String licenseNumber;
    private Integer yearsOfExperience;
    private Boolean isActive;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private StatusDto status;
}
