package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.CountryDto;
import com.example.FilmManagment.dto.request.CountryRequest;
import com.example.FilmManagment.model.Country;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    final CountryService service;

    @GetMapping("/countryList")
    public ResponseEntity<BaseResponse<List<CountryDto>>> getCountryInfo() {
        List<CountryDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country list successfuly find", list));
    }

    @GetMapping("/getCountriesByCountryId/{countryId}")
    public ResponseEntity<BaseResponse<CountryDto>> getCitiesByCityId(@PathVariable(value = "countryId") Long countryId) {
        CountryDto dto = service.getCountriesByCountryId(countryId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country successfuly find", dto));
    }

    @PostMapping("/saveCountry")
    public ResponseEntity<BaseResponse<Country>> saveCountry(@RequestBody CountryRequest request) {
        Country country = service.saveCountry(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country successfuly saved", country));
    }

    @PutMapping("/updateCountry")
    public ResponseEntity<BaseResponse<CountryDto>> updateCity(@RequestBody CountryRequest request) {
        CountryDto country = service.updateCountry(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Country successfuly saved", country));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }

}

