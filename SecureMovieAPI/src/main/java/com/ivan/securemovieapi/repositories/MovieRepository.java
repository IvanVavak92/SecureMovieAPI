package com.ivan.securemovieapi.repositories;

import com.ivan.securemovieapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByTitleContainingIgnoreCase(String query);
}
