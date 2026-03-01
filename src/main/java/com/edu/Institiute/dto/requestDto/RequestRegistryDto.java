package com.edu.Institiute.dto.requestDto;

import com.edu.Institiute.dto.StatusDto;
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
    private Integer userId;
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
