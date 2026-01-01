package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.DoctorResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseDoctorDto {

    private Long count;
    private List<DoctorResponseDto>dataList;

}
