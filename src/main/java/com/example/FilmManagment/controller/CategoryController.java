package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.CategoryDto;
import com.example.FilmManagment.dto.request.CategoryRequest;
import com.example.FilmManagment.model.Category;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    final CategoryService service;

    @GetMapping("/categoryList")
    public ResponseEntity<BaseResponse<List<CategoryDto>>> getCategoryInfo() {
        List<CategoryDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Category list successfuly find", list));
    }

    @GetMapping("/getCategoriesByCategoryId/{categoryId}")
    public ResponseEntity<BaseResponse<CategoryDto>> getCategoriesByCategoryId(@PathVariable(value = "categoryId") Long categoryId) {
        CategoryDto dto = service.getCategoriesByCategoryId(categoryId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Category successfuly find", dto));
    }

    @PostMapping("/saveCategory")
    public ResponseEntity<BaseResponse<Category>> saveCategory(@RequestBody CategoryRequest request) {
        Category category = service.saveCategory(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Category successfuly saved", category));
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<BaseResponse<CategoryDto>> updateCity(@RequestBody CategoryRequest request) {
        CategoryDto category = service.updateCategory(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Category successfuly saved", category));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }

}
