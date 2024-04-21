package com.ivan.securemovieapi.services;

import com.ivan.securemovieapi.dtos.MovieResponseDTO;
import com.ivan.securemovieapi.models.Movie;


import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    void save(Movie movie);

    List<Movie> getMyMovies();
    List<Movie> findByTitle(String title);

    MovieResponseDTO getMovies(String title);



}
