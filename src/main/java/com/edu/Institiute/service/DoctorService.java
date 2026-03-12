package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;


public interface DoctorService {
    CommonResponseDto saveDoctor(RequestRegistryDto dto);

    CommonResponseDto updateDoctor(RequestRegistryDto dto,String doctorId);

    CommonResponseDto removeDoctor(String DoctorId);
}
