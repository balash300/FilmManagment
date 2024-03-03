package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.FilmTextDto;
import com.example.FilmManagment.dto.request.FilmTextRequest;
import com.example.FilmManagment.model.FilmText;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.FilmTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmText")
public class FilmTextController {

    final FilmTextService service;

    @GetMapping("/filmTextList")
    public ResponseEntity<BaseResponse<List<FilmTextDto>>> getFilmTextInfo() {
        List<FilmTextDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film text list successfuly find", list));
    }

    @GetMapping("/getFilmTextByFilmId/{filmId}")
    public ResponseEntity<BaseResponse<FilmTextDto>> getFilmTextByFilmId(@PathVariable(value = "filmId") Long filmId) {
        FilmTextDto dto = service.getFilmTextByFilmId(filmId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film text successfuly find", dto));
    }

    @PostMapping("/saveFilmText")
    public ResponseEntity<BaseResponse<FilmText>> saveFilmText(@RequestBody FilmTextRequest request) {
        FilmText film = service.saveFilmText(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film text successfuly saved", film));
    }

    @PutMapping("/updateFilmText")
    public ResponseEntity<BaseResponse<FilmTextDto>> updateFilmText(@RequestBody FilmTextRequest request) {
        FilmTextDto dto = service.updateFilmText(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Film text successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}