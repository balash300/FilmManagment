package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.FilmActorDto;
import com.example.FilmManagment.dto.request.FilmActorRequest;
import com.example.FilmManagment.model.FilmActor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FilmActorMapper {
    FilmActorDto toDto(FilmActor filmActor);
    FilmActor toEntity(FilmActorRequest request);
    List<FilmActorDto> dtoList(List<FilmActor> list);
}
