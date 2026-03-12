package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.DoctorDto;
import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Doctor;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.DoctorRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.service.DoctorService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.DoctorMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class DoctorRegistryImpl implements DoctorService {

    @Autowired
    private Generator generator;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    public DoctorRegistryImpl(Generator generator) { this.generator = generator;}

    @Override
    public CommonResponseDto saveDoctor(RequestRegistryDto dto){
        try {
            String doctorRegistryCode = "IBM-S" + "-" + generator.generateFourNumbers();
            String doctorId = generator.generateFourNumbers();
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
            System.out.println("data "+dto);

            DoctorDto doctorDto = new DoctorDto(
                    doctorRegistryCode,
                    dto.getUserId(),
                    dto.getSpecializations(),
                    dto.getQualifications(),
                    dto.getLicenceNumber(),
                    dto.getYearsOfExperience(),
                    dto.getIsActive(),
                    dto.getCreatedBy(),
                    dto.getCreatedDate(),
                    dto.getModifiedBy(),
                    dto.getModifiedDate(),
                    statusMapper.toStatusDto(status.get())
            );
            doctorRepo.save(doctorMapper.dtoToDoctorEntity(doctorDto));

            return new CommonResponseDto(201, "Doctor Saved! ", doctorDto.getDoctorId(),new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't save because of this Error -->" +e);
}
}

    @Override
    public CommonResponseDto updateDoctor(RequestRegistryDto dto, String doctorId){
        try {

            Doctor allDoctorForProvidedId = doctorRepo.findByDocId(doctorId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

            allDoctorForProvidedId.setDoctorId(dto.getDoctorId());
            allDoctorForProvidedId.setUserId(dto.getUserId());
            allDoctorForProvidedId.setSpecializations(dto.getSpecializations());
            allDoctorForProvidedId.setQualifications(dto.getQualifications());
            allDoctorForProvidedId.setLicenseNumber(dto.getLicenceNumber());
            allDoctorForProvidedId.setYearsOfExperience(dto.getYearsOfExperience());
            allDoctorForProvidedId.setActive(dto.getIsActive());
            allDoctorForProvidedId.setCreatedBy(dto.getCreatedBy());
            allDoctorForProvidedId.setCreatedDate(dto.getCreatedDate());
            allDoctorForProvidedId.setModifiedBy(dto.getModifiedBy());
            allDoctorForProvidedId.setModifiedDate(dto.getModifiedDate());
            allDoctorForProvidedId.setStatus(status.get());

            doctorRepo.save(allDoctorForProvidedId);

            return new CommonResponseDto(201,"Doctor Updated",allDoctorForProvidedId.getDoctorId(),new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error-->"+e);
        }
    }

}
