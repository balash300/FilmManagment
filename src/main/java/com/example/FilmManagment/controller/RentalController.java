package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.RentalDto;
import com.example.FilmManagment.dto.request.RentalRequest;
import com.example.FilmManagment.model.Rental;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalController {

    final RentalService service;

    @GetMapping("/rentalList")
    public ResponseEntity<BaseResponse<List<RentalDto>>> getRentalInfo() {
        List<RentalDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Rental list successfuly find", list));
    }

    @GetMapping("/getRentalByRentalId/{rentalId}")
    public ResponseEntity<BaseResponse<RentalDto>> getRentalByRentalId(@PathVariable(value = "rentalId") Long rentalId) {
        RentalDto dto = service.getRentalByRentalId(rentalId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Rental successfuly find", dto));
    }

    @PostMapping("/saveRental")
    public ResponseEntity<BaseResponse<Rental>> saveRental(@RequestBody RentalRequest request) {
        Rental rental = service.saveRental(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Rental successfuly saved", rental));
    }

    @PutMapping("/updateRental")
    public ResponseEntity<BaseResponse<RentalDto>> updateRental(@RequestBody RentalRequest request) {
        RentalDto dto = service.updateRental(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Rental successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}
