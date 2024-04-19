package com.ivan.securemovieapi.repositories;

import com.ivan.securemovieapi.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Optional<Film> findByTitle(String title);
}
