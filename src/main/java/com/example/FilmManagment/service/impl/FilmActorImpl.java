package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.FilmActorDto;
import com.example.FilmManagment.dto.request.FilmActorRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.FilmActorMapper;
import com.example.FilmManagment.model.FilmActor;
import com.example.FilmManagment.repository.FilmActorRepository;
import com.example.FilmManagment.service.FilmActorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmActorImpl implements FilmActorService {

    private final FilmActorRepository repository;
    private final FilmActorMapper mapper;

    @Override
    public FilmActorDto getFilmActorById(Long id) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("FilmActor", "id", id)));
    }

    @Override
    public FilmActor saveFilmActor(FilmActorRequest request) {
        FilmActor filmActor = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return filmActor;
    }

    @Override
    public FilmActorDto updateFilmActor(FilmActorRequest request) {
        log.info("Finding information for id: {}", request.getId());
        if (repository.findById(request.getId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getId());
        } else {
            log.info("Updating information for id: {}", request.getId());
            FilmActor updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("FilmActor", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<FilmActorDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
