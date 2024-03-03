package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.CountryDto;
import com.example.FilmManagment.dto.request.CountryRequest;
import com.example.FilmManagment.model.Country;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CountryMapper {
    CountryDto toDto(Country country);
    Country toEntity(CountryRequest request);
    List<CountryDto> dtoList(List<Country> list);
}
