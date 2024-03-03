package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.StaffDto;
import com.example.FilmManagment.dto.request.StaffRequest;
import com.example.FilmManagment.model.Staff;

import java.util.List;

public interface StaffService {

    StaffDto getStaffByStaffId(Long staffId);
    Staff saveStaff(StaffRequest request);
    StaffDto updateStaff(StaffRequest request);
    void deleteById(Long id);
    List<StaffDto> getAll();

}
