package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.CityDto;
import com.example.FilmManagment.dto.request.CityRequest;
import com.example.FilmManagment.model.City;

import java.util.List;

public interface CityService {

    CityDto getCitiesByCityId(Long cityId);
    City saveCity(CityRequest request);
    CityDto updateCity(CityRequest request);
    void deleteById(Long id);
    List<CityDto> getAll();

}
