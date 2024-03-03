package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.RentalDto;
import com.example.FilmManagment.dto.request.RentalRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.RentalMapper;
import com.example.FilmManagment.model.Rental;
import com.example.FilmManagment.repository.RentalRepository;
import com.example.FilmManagment.service.RentalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalImpl implements RentalService {

    private final RentalRepository repository;
    private final RentalMapper mapper;

    @Override
    public RentalDto getRentalByRentalId(Long rentalId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(rentalId)
                .orElseThrow(()-> new ResourceNotFoundException("Rental","rentalId",rentalId)));
    }

    @Override
    public Rental saveRental(RentalRequest request) {
        Rental rental = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return rental;
    }

    @Override
    public RentalDto updateRental(RentalRequest request) {
        log.info("Finding information for id: {}", request.getRentalId());
        if (repository.findById(request.getRentalId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getRentalId());
        } else {
            log.info("Updating information for id: {}", request.getRentalId());
            Rental updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getRentalId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Rental", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<RentalDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());    }
}
