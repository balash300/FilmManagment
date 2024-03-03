package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.StaffDto;
import com.example.FilmManagment.dto.request.StaffRequest;
import com.example.FilmManagment.model.Staff;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StaffMapper {
    StaffDto toDto(Staff staff);
    Staff toEntity(StaffRequest request);
    List<StaffDto> dtoList(List<Staff> list);
}
