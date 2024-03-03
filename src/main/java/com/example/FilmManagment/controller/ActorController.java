package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.ActorDto;
import com.example.FilmManagment.dto.request.ActorRequest;
import com.example.FilmManagment.model.Actor;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actor")
public class ActorController {

    final ActorService service;

    @GetMapping("/actorList")
    public ResponseEntity<BaseResponse<List<ActorDto>>> getActorInfo() {
        List<ActorDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Actor list successfully find", list));
    }

    @GetMapping("/getActorByActorId/{actorId}")
    public ResponseEntity<BaseResponse<ActorDto>> getActorByActorId(@PathVariable(value = "actorId") Long actorId) {
        ActorDto actorDto = service.getActorByActorId(actorId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Actor successfully find", actorDto));
    }

    @PostMapping("/saveActor")
    public ResponseEntity<BaseResponse<Actor>> saveActor(@RequestBody ActorRequest request) {
        Actor actor = service.saveActor(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Actor successfully saved", actor));
    }

    @PutMapping("/updateActor")
    public ResponseEntity<BaseResponse<ActorDto>> updateActor(@RequestBody ActorRequest request) {
        ActorDto actor = service.updateActor(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Actor successfully updated", actor));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfully deleted");
    }

}
