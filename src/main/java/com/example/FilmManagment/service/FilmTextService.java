package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.FilmTextDto;
import com.example.FilmManagment.dto.request.FilmTextRequest;
import com.example.FilmManagment.model.FilmText;

import java.util.List;

public interface FilmTextService {

    FilmTextDto getFilmTextByFilmId(Long filmId);
    FilmText saveFilmText(FilmTextRequest request);
    FilmTextDto updateFilmText(FilmTextRequest request);
    void deleteById(Long id);
    List<FilmTextDto> getAll();

}
