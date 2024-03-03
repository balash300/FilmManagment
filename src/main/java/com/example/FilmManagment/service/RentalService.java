package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.RentalDto;
import com.example.FilmManagment.dto.request.RentalRequest;
import com.example.FilmManagment.model.Rental;

import java.util.List;

public interface RentalService {

    RentalDto getRentalByRentalId(Long rentalId);
    Rental saveRental(RentalRequest request);
    RentalDto updateRental(RentalRequest request);
    void deleteById(Long id);
    List<RentalDto> getAll();

}
