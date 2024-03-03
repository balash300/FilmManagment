package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.LanguageDto;
import com.example.FilmManagment.dto.request.LanguageRequest;
import com.example.FilmManagment.model.Language;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LanguageMapper {
    LanguageDto toDto(Language language);
    Language toEntity(LanguageRequest request);
    List<LanguageDto> dtoList(List<Language> list);
}
