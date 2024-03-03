package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.FilmActorDto;
import com.example.FilmManagment.dto.request.FilmActorRequest;
import com.example.FilmManagment.model.FilmActor;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.FilmActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmActor")
public class FilmActorController {

    final FilmActorService service;

    @GetMapping("/filmActorList")
    public ResponseEntity<BaseResponse<List<FilmActorDto>>> getFilmActorInfo() {
        List<FilmActorDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Actor list successfuly find", list));
    }

    @GetMapping("/getFilmActorById/{id}")
    public ResponseEntity<BaseResponse<FilmActorDto>> getFilmActorById(@PathVariable(value = "id") Long id) {
        FilmActorDto dto = service.getFilmActorById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Actor successfuly find", dto));
    }

    @PostMapping("/saveFilmActor")
    public ResponseEntity<BaseResponse<FilmActor>> saveFilmActor(@RequestBody FilmActorRequest request) {
        FilmActor filmActor = service.saveFilmActor(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Actor successfuly saved", filmActor));
    }

    @PutMapping("/updateFilmActor")
    public ResponseEntity<BaseResponse<FilmActorDto>> updateFilmActor(@RequestBody FilmActorRequest request) {
        FilmActorDto dto = service.updateFilmActor(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film Actor successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}

