package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.FilmCategoryDto;
import com.example.FilmManagment.dto.request.FilmCategoryRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.FilmCategoryMapper;
import com.example.FilmManagment.model.FilmCategory;
import com.example.FilmManagment.repository.FilmCategoryRepository;
import com.example.FilmManagment.service.FilmCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmCategoryImpl implements FilmCategoryService {

    private final FilmCategoryRepository repository;
    private final FilmCategoryMapper mapper;

    @Override
    public FilmCategoryDto getFilmCategoriesById(Long id) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("FilmCategory", "id", id)));
    }

    @Override
    public FilmCategory saveFilmCategory(FilmCategoryRequest request) {
        FilmCategory filmCategory = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return filmCategory;
    }

    @Override
    public FilmCategoryDto updateFilmCategory(FilmCategoryRequest request) {
        log.info("Finding information for id: {}", request.getId());
        if (repository.findById(request.getId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getId());
        } else {
            log.info("Updating information for id: {}", request.getId());
            FilmCategory updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("FilmCategory", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<FilmCategoryDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());    }
}
