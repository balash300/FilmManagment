package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.LanguageDto;
import com.example.FilmManagment.dto.request.LanguageRequest;
import com.example.FilmManagment.model.Language;

import java.util.List;

public interface LanguageService {

    LanguageDto getLanguagesByLanguageId(Long languageId);
    Language saveLanguage(LanguageRequest request);
    LanguageDto updateLanguage(LanguageRequest request);
    void deleteById(Long id);
    List<LanguageDto> getAll();

}
