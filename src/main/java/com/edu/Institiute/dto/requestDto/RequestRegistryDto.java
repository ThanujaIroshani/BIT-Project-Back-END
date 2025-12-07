package com.edu.Institiute.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RequestRegistryDto {

    private String studentCode;
    private String studentName;
    private String studentAge;
    private String studentNic;
    private Integer status;

    private String courseCode;
    private String courseName;

    //doctor

    private String DoctorId;
    private String UserId;
    private String Specification;
    private String Qualifications;
    private String LicenceNumber;
    private Integer YearsOfExperience;
    private Boolean IsActive;
    private String CreatedBy;
    private Date CreatedDate;
    private String ModifyBy;
    private Date ModifyDate;
}
