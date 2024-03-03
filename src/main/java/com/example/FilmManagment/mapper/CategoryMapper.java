package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.CategoryDto;
import com.example.FilmManagment.dto.request.CategoryRequest;
import com.example.FilmManagment.model.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryRequest request);
    List<CategoryDto> dtoList(List<Category> list);
}
