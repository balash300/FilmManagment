package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.ActorDto;
import com.example.FilmManagment.dto.request.ActorRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.ActorMapper;
import com.example.FilmManagment.model.Actor;
import com.example.FilmManagment.repository.ActorRepository;
import com.example.FilmManagment.service.ActorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActorImpl implements ActorService {

    private final ActorRepository repository;
    private final ActorMapper mapper;

    @Override
    public ActorDto getActorByActorId(Long actorId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(actorId)
                .orElseThrow(()-> new ResourceNotFoundException("Actor","actorId",actorId)));
    }

    @Override
    public Actor saveActor(ActorRequest request) {
        Actor actor = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return actor;
    }

    @Override
    public ActorDto updateActor(ActorRequest request) {
        log.info("Finding information for id: {}", request.getActorId());
        if (repository.findById(request.getActorId()).isEmpty()) {
            throw new ResourceNotFoundException("Actor", "id", request.getActorId());
        } else {
            log.info("Updating information for id: {}", request.getActorId());
            Actor updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getActorId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Actor", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<ActorDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
