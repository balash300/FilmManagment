package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.FilmTextDto;
import com.example.FilmManagment.dto.request.FilmTextRequest;
import com.example.FilmManagment.model.FilmText;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FilmTextMapper {
    FilmTextDto toDto(FilmText filmText);
    FilmText toEntity(FilmTextRequest request);
    List<FilmTextDto> dtoList(List<FilmText> list);
}
