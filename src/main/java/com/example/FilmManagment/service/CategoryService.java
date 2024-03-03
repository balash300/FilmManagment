package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.CategoryDto;
import com.example.FilmManagment.dto.request.CategoryRequest;
import com.example.FilmManagment.model.Category;

import java.util.List;

public interface CategoryService {

    CategoryDto getCategoriesByCategoryId(Long categoryId);
    Category saveCategory(CategoryRequest request);
    CategoryDto updateCategory(CategoryRequest request);
    void deleteById(Long id);
    List<CategoryDto> getAll();

}
