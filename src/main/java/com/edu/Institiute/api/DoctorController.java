package com.edu.Institiute.api;



import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.DoctorService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedDoctor(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = doctorService.saveDoctor(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }
    @CrossOrigin(origins = "http:localhost:4200//")
    @PutMapping("{doctorId")
    public ResponseEntity<StandardResponse> updateDoctor(@RequestBody RequestRegistryDto data,@PathVariable String doctorId){
        CommonResponseDto responseData = doctorService.updateDoctor(data,doctorId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }


    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("{studentId}")
    public ResponseEntity<StandardResponse> deleteDoctor(@PathVariable String doctorId){
        CommonResponseDto responseData = doctorService.removeDoctor(doctorId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

}
