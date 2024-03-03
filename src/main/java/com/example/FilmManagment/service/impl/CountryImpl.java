package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.CountryDto;
import com.example.FilmManagment.dto.request.CountryRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.CountryMapper;
import com.example.FilmManagment.model.Country;
import com.example.FilmManagment.repository.CountryRepository;
import com.example.FilmManagment.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryImpl implements CountryService {

    private final CountryRepository repository;
    private final CountryMapper mapper;

    @Override
    public CountryDto getCountriesByCountryId(Long countryId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(countryId)
                .orElseThrow(()-> new ResourceNotFoundException("Country", "countryId", countryId)));
    }

    @Override
    public Country saveCountry(CountryRequest request) {
        Country country = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return country;
    }

    @Override
    public CountryDto updateCountry(CountryRequest request) {
        log.info("Finding information for id: {}", request.getCountryId());
        if (repository.findById(request.getCountryId()).isEmpty()) {
            throw new ResourceNotFoundException("Country", "id", request.getCountryId());
        } else {
            log.info("Updating information for id: {}", request.getCountryId());
            Country updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getCountryId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Country", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<CountryDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
