package com.example.FilmManagment.repository;

import com.example.FilmManagment.model.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, Long> {
}
