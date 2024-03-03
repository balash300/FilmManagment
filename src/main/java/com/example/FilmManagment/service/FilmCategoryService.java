package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.FilmCategoryDto;
import com.example.FilmManagment.dto.request.FilmCategoryRequest;
import com.example.FilmManagment.model.FilmCategory;

import java.util.List;

public interface FilmCategoryService {

    FilmCategoryDto getFilmCategoriesById(Long id);
    FilmCategory saveFilmCategory(FilmCategoryRequest request);
    FilmCategoryDto updateFilmCategory(FilmCategoryRequest request);
    void deleteById(Long id);
    List<FilmCategoryDto> getAll();

}