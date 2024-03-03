package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.FilmDto;
import com.example.FilmManagment.dto.request.FilmRequest;
import com.example.FilmManagment.model.Film;

import java.util.List;

public interface FilmService {

    FilmDto getFilmByFilmId(Long filmId);
    Film saveFilm(FilmRequest request);
    FilmDto updateFilm(FilmRequest request);
    void deleteById(Long id);
    List<FilmDto> getAll();

}
