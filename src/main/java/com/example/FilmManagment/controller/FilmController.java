package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.FilmDto;
import com.example.FilmManagment.dto.request.FilmRequest;
import com.example.FilmManagment.model.Film;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film")
public class FilmController {

    final FilmService service;

    @GetMapping("/filmList")
    public ResponseEntity<BaseResponse<List<FilmDto>>> getFilmInfo() {
        List<FilmDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film list successfuly find", list));
    }

    @GetMapping("/getFilmByFilmId/{filmId}")
    public ResponseEntity<BaseResponse<FilmDto>> getFilmByFilmId(@PathVariable(value = "filmId") Long filmId) {
        FilmDto dto = service.getFilmByFilmId(filmId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film successfuly find", dto));
    }

    @PostMapping("/saveFilm")
    public ResponseEntity<BaseResponse<Film>> saveFilm(@RequestBody FilmRequest request) {
        Film film = service.saveFilm(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film successfuly saved", film));
    }

    @PutMapping("/updateFilm")
    public ResponseEntity<BaseResponse<FilmDto>> updateFilm(@RequestBody FilmRequest request) {
        FilmDto dto = service.updateFilm(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}
