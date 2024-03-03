package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.LanguageDto;
import com.example.FilmManagment.dto.request.LanguageRequest;
import com.example.FilmManagment.model.Language;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/language")
public class LanguageController {

    final LanguageService service;

    @GetMapping("/languageList")
    public ResponseEntity<BaseResponse<List<LanguageDto>>> getLanguageInfo() {
        List<LanguageDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Language list successfuly find", list));
    }

    @GetMapping("/getLanguagesByLanguageId/{languageId}")
    public ResponseEntity<BaseResponse<LanguageDto>> getLanguagesByLanguageId(@PathVariable(value = "languageId") Long languageId) {
        LanguageDto dto = service.getLanguagesByLanguageId(languageId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Language successfuly find", dto));
    }

    @PostMapping("/saveLanguage")
    public ResponseEntity<BaseResponse<Language>> saveLanguage(@RequestBody LanguageRequest request) {
        Language language = service.saveLanguage(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Language successfuly saved", language));
    }

    @PutMapping("/updateLanguage")
    public ResponseEntity<BaseResponse<LanguageDto>> updateLangauge(@RequestBody LanguageRequest request) {
        LanguageDto dto = service.updateLanguage(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Language successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}
