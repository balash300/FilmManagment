package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.FilmCategoryDto;
import com.example.FilmManagment.dto.request.FilmCategoryRequest;
import com.example.FilmManagment.model.FilmCategory;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FilmCategoryMapper {
    FilmCategoryDto toDto(FilmCategory filmCategory);
    FilmCategory toEntity(FilmCategoryRequest request);
    List<FilmCategoryDto> dtoList(List<FilmCategory> list);
}
