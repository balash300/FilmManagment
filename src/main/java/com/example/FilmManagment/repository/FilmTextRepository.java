package com.example.FilmManagment.repository;

import com.example.FilmManagment.model.FilmText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmTextRepository extends JpaRepository<FilmText, Long> {
}
