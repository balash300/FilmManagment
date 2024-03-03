package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.FilmDto;
import com.example.FilmManagment.dto.request.FilmRequest;
import com.example.FilmManagment.model.Film;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FilmMapper {
    FilmDto toDto(Film film);
    Film toEntity(FilmRequest request);
    List<FilmDto> dtoList(List<Film> list);
}
