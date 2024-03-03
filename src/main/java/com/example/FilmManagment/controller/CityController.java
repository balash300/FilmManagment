package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.CityDto;
import com.example.FilmManagment.dto.request.CityRequest;
import com.example.FilmManagment.model.City;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    final CityService service;

    @GetMapping("/cityList")
    public ResponseEntity<BaseResponse<List<CityDto>>> getCityInfo() {
        List<CityDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City list successfuly find", list));
    }

    @GetMapping("/getCitiesByCityId/{cityId}")
    public ResponseEntity<BaseResponse<CityDto>> getCitiesByCityId(@PathVariable(value = "cityId") Long cityId) {
        CityDto dto = service.getCitiesByCityId(cityId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City successfuly find", dto));
    }

    @PostMapping("/saveCity")
    public ResponseEntity<BaseResponse<City>> saveCity(@RequestBody CityRequest request) {
        City city = service.saveCity(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City successfuly saved", city));
    }

    @PutMapping("/updateCity")
    public ResponseEntity<BaseResponse<CityDto>> updateCity(@RequestBody CityRequest request) {
        CityDto city = service.updateCity(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "City successfuly saved", city));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }

}
