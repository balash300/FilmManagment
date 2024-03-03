package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.FilmTextDto;
import com.example.FilmManagment.dto.request.FilmTextRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.FilmTextMapper;
import com.example.FilmManagment.model.FilmText;
import com.example.FilmManagment.repository.FilmTextRepository;
import com.example.FilmManagment.service.FilmTextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmTextImpl implements FilmTextService {

    private final FilmTextRepository repository;
    private final FilmTextMapper mapper;

    @Override
    public FilmTextDto getFilmTextByFilmId(Long filmId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(filmId)
                .orElseThrow(()-> new ResourceNotFoundException("FilmText","filmId",filmId)));
    }

    @Override
    public FilmText saveFilmText(FilmTextRequest request) {
        FilmText filmText = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return filmText;
    }

    @Override
    public FilmTextDto updateFilmText(FilmTextRequest request) {
        log.info("Finding information for id: {}", request.getFilmId());
        if (repository.findById(request.getFilmId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getFilmId());
        } else {
            log.info("Updating information for id: {}", request.getFilmId());
            FilmText updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getFilmId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("FilmText", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<FilmTextDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
