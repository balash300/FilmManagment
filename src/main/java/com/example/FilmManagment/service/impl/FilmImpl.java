package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.FilmDto;
import com.example.FilmManagment.dto.request.FilmRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.FilmMapper;
import com.example.FilmManagment.model.Film;
import com.example.FilmManagment.repository.FilmRepository;
import com.example.FilmManagment.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmImpl implements FilmService {

    private final FilmRepository repository;
    private final FilmMapper mapper;

    @Override
    public FilmDto getFilmByFilmId(Long filmId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(filmId)
                .orElseThrow(()-> new ResourceNotFoundException("Film", "filmId", filmId)));
    }

    @Override
    public Film saveFilm(FilmRequest request) {
        Film film = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return film;
    }

    @Override
    public FilmDto updateFilm(FilmRequest request) {
        log.info("Finding information for id: {}", request.getFilmId());
        if (repository.findById(request.getFilmId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getFilmId());
        } else {
            log.info("Updating information for id: {}", request.getFilmId());
            Film updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getFilmId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Film", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<FilmDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());    }
}
