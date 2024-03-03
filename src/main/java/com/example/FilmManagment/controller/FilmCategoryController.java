package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.FilmCategoryDto;
import com.example.FilmManagment.dto.request.FilmCategoryRequest;
import com.example.FilmManagment.model.FilmCategory;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.FilmCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmCategory")
public class FilmCategoryController {

    final FilmCategoryService service;

    @GetMapping("/filmCategoryList")
    public ResponseEntity<BaseResponse<List<FilmCategoryDto>>> getFilmCategoryInfo() {
        List<FilmCategoryDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Category list successfuly find", list));
    }

    @GetMapping("/getFilmCategoriesById/{id}")
    public ResponseEntity<BaseResponse<FilmCategoryDto>> getFilmCategoriesById(@PathVariable(value = "id") Long id) {
        FilmCategoryDto dto = service.getFilmCategoriesById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Category successfuly find", dto));
    }

    @PostMapping("/saveFilmCategory")
    public ResponseEntity<BaseResponse<FilmCategory>> saveFilmCategory(@RequestBody FilmCategoryRequest request) {
        FilmCategory filmCategory = service.saveFilmCategory(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Category successfuly saved", filmCategory));
    }

    @PutMapping("/updateFilmCategory")
    public ResponseEntity<BaseResponse<FilmCategoryDto>> updateFilmCategory(@RequestBody FilmCategoryRequest request) {
        FilmCategoryDto dto = service.updateFilmCategory(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Category successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}
