package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.RentalDto;
import com.example.FilmManagment.dto.request.RentalRequest;
import com.example.FilmManagment.model.Rental;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RentalMapper {
    RentalDto toDto(Rental rental);
    Rental toEntity(RentalRequest request);
    List<RentalDto> dtoList(List<Rental> list);
}
