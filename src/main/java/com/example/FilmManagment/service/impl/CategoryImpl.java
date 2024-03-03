package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.CategoryDto;
import com.example.FilmManagment.dto.request.CategoryRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.CategoryMapper;
import com.example.FilmManagment.model.Category;
import com.example.FilmManagment.repository.CategoryRepository;
import com.example.FilmManagment.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public CategoryDto getCategoriesByCategoryId(Long categoryId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Actor","actorId",categoryId)));
    }

    @Override
    public Category saveCategory(CategoryRequest request) {
        Category category = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return category;
    }

    @Override
    public CategoryDto updateCategory(CategoryRequest request) {
        log.info("Finding information for id: {}", request.getCategoryId());
        if (repository.findById(request.getCategoryId()).isEmpty()) {
            throw new ResourceNotFoundException("Category", "id", request.getCategoryId());
        } else {
            log.info("Updating information for id: {}", request.getCategoryId());
            Category updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getCategoryId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Category", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<CategoryDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
