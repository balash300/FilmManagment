package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.ActorDto;
import com.example.FilmManagment.dto.request.ActorRequest;
import com.example.FilmManagment.model.Actor;

import java.util.List;

public interface ActorService {

    ActorDto getActorByActorId(Long actorId);
    Actor saveActor(ActorRequest request);
    ActorDto updateActor(ActorRequest request);
    void deleteById(Long id);
    List<ActorDto> getAll();

}
