package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.CityDto;
import com.example.FilmManagment.dto.request.CityRequest;
import com.example.FilmManagment.model.City;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CityMapper {
    CityDto toDto(City city);
    City toEntity(CityRequest request);
    List<CityDto> dtoList(List<City> list);
}
