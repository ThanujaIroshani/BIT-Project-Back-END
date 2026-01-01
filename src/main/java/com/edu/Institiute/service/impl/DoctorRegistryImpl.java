package com.edu.Institiute.service.impl;
import com.edu.Institiute.dto.DoctorDto;
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
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class DoctorRegistryImpl implements DoctorService {

    private final Generator generator;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    public DoctorRegistryImpl(Generator generator){ this.generator=generator; }

    @Override
    public CommonResponseDto saveDoctor(RequestRegistryDto dto){
        try {
            String doctorId = generator.generateFourNumbers();
            String doctorUserId = "D-ID"+"-"+ generator.generateFourNumbers();

            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());


            DoctorDto doctorDto = new DoctorDto(
                    doctorId,
                    doctorUserId,
                    dto.getSpecializations(),
                    dto.getQualifications(),
                    dto.getLicenceNumber(),
                    dto.getYearsOfExperience(),
                    dto.getIsActive(),
                    dto.getCreatedBy(),
                    new Date(),
                    "",
                    new Date(0)
            );


            doctorRepo.save(doctorMapper.dtoToDoctorEntity(doctorDto));

            return new CommonResponseDto(201, "Doctor  saved!", doctorDto.getDoctorId(), new ArrayList<>());

        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateDoctor(RequestRegistryDto dto, String doctorId){
        try {
            Doctor allDoctorForProvidedId = doctorRepo.findByDoctorId(doctorId);
            Optional<Status> status= statusRepo.findStatusById(dto.getStatus());

                allDoctorForProvidedId.setDoctorId(dto.getDoctorId());
                allDoctorForProvidedId.setUserId(dto.getUserId());
                allDoctorForProvidedId.setSpecializations(dto.getSpecializations());
                allDoctorForProvidedId.setQualifications(dto.getQualifications());
                allDoctorForProvidedId.setLicenceNumber(dto.getLicenceNumber());
                allDoctorForProvidedId.setYearsOfExperience(dto.getYearsOfExperience());
                allDoctorForProvidedId.setIsActive(dto.getIsActive());
                allDoctorForProvidedId.setCreatedBy(dto.getCreatedBy());
                allDoctorForProvidedId.setCreatedDate(dto.getCreatedDate());
                allDoctorForProvidedId.setModifiedBy(dto.getModifiedBy());
                allDoctorForProvidedId.setModifiedDate(new Date());

            doctorRepo.save(allDoctorForProvidedId);

            return new CommonResponseDto( 201 , "Doctor Updated!", allDoctorForProvidedId.getDoctorId(),new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->" +e);
        }
    }
}
