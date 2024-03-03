package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.FilmActorDto;
import com.example.FilmManagment.dto.request.FilmActorRequest;
import com.example.FilmManagment.model.FilmActor;

import java.util.List;

public interface FilmActorService {

    FilmActorDto getFilmActorById(Long id);
    FilmActor saveFilmActor(FilmActorRequest request);
    FilmActorDto updateFilmActor(FilmActorRequest request);
    void deleteById(Long id);
    List<FilmActorDto> getAll();

}
