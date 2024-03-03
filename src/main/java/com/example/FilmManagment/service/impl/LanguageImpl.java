package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.LanguageDto;
import com.example.FilmManagment.dto.request.LanguageRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.LanguageMapper;
import com.example.FilmManagment.model.Language;
import com.example.FilmManagment.repository.LanguageRepository;
import com.example.FilmManagment.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LanguageImpl implements LanguageService {

    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    @Override
    public LanguageDto getLanguagesByLanguageId(Long languageId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(languageId)
                .orElseThrow(()-> new ResourceNotFoundException("Language","languageId",languageId)));
    }

    @Override
    public Language saveLanguage(LanguageRequest request) {
        Language language = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return language;
    }

    @Override
    public LanguageDto updateLanguage(LanguageRequest request) {
        log.info("Finding information for id: {}", request.getLanguageId());
        if (repository.findById(request.getLanguageId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getLanguageId());
        } else {
            log.info("Updating information for id: {}", request.getLanguageId());
            Language updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getLanguageId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Language", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<LanguageDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
