package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.ActorDto;
import com.example.FilmManagment.dto.request.ActorRequest;
import com.example.FilmManagment.model.Actor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ActorMapper {
    ActorDto toDto(Actor actor);
    Actor toEntity(ActorRequest request);
    List<ActorDto> dtoList(List<Actor> list);
}
