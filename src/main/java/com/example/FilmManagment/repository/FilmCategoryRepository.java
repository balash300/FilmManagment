package com.example.FilmManagment.repository;

import com.example.FilmManagment.model.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Long> {
}
