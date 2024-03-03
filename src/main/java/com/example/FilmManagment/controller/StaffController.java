package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.StaffDto;
import com.example.FilmManagment.dto.request.StaffRequest;
import com.example.FilmManagment.model.Staff;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    final StaffService service;

    @GetMapping("/staffList")
    public ResponseEntity<BaseResponse<List<StaffDto>>> getStaffInfo() {
        List<StaffDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Staff list successfuly find", list));
    }

    @GetMapping("/getStaffByRentalId/{staffId}")
    public ResponseEntity<BaseResponse<StaffDto>> getStaffByStaffId(@PathVariable(value = "staffId") Long staffId) {
        StaffDto dto = service.getStaffByStaffId(staffId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Staff successfuly find", dto));
    }

    @PostMapping("/saveStaff")
    public ResponseEntity<BaseResponse<Staff>> saveStaff(@RequestBody StaffRequest request) {
        Staff staff = service.saveStaff(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Staff successfuly saved", staff));
    }

    @PutMapping("/updateStaff")
    public ResponseEntity<BaseResponse<StaffDto>> updateStaff(@RequestBody StaffRequest request) {
        StaffDto dto = service.updateStaff(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Staff successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}
