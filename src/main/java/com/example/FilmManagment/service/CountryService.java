package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.CountryDto;
import com.example.FilmManagment.dto.request.CountryRequest;
import com.example.FilmManagment.model.Country;

import java.util.List;

public interface CountryService {

    CountryDto getCountriesByCountryId(Long countryId);
    Country saveCountry(CountryRequest request);
    CountryDto updateCountry(CountryRequest request);
    void deleteById(Long id);
    List<CountryDto> getAll();

}
