package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.CityDto;
import com.example.FilmManagment.dto.request.CityRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.CityMapper;
import com.example.FilmManagment.model.City;
import com.example.FilmManagment.repository.CityRepository;
import com.example.FilmManagment.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityImpl implements CityService {

    private final CityRepository repository;
    private final CityMapper mapper;

    @Override
    public CityDto getCitiesByCityId(Long cityId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(cityId)
                .orElseThrow(()-> new ResourceNotFoundException("City", "cityId", cityId)));
    }

    @Override
    public City saveCity(CityRequest request) {
        City city = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return city;
    }

    @Override
    public CityDto updateCity(CityRequest request) {
        log.info("Finding information for id: {}", request.getCityId());
        if (repository.findById(request.getCityId()).isEmpty()) {
            throw new ResourceNotFoundException("City", "id", request.getCityId());
        } else {
            log.info("Updating information for id: {}", request.getCityId());
            City updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getCityId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("City", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<CityDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
