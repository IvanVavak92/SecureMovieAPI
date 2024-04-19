package com.ivan.securemovieapi.services;

import com.ivan.securemovieapi.dtos.MovieDTO;
import com.ivan.securemovieapi.dtos.MovieResponseDTO;
import com.ivan.securemovieapi.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private MovieServiceApi movieServiceApi;
    private FilmRepository filmRepository;


    @Autowired
    public MovieService(MovieServiceApi movieServiceApi, FilmRepository filmRepository) {
        this.movieServiceApi = movieServiceApi;
        this.filmRepository = filmRepository;
    }

    public List<MovieDTO> getFilms() {
        List<MovieDTO> filmDTOList = new ArrayList<>();

        // Make a request to the API to get popular movies
        Call<MovieResponseDTO> call = movieServiceApi.getPopularMovies(
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyNGVjNzY1YTZmZTY1OTVlM2M1NGMyNmIyYmM4NWE4OSIsInN1YiI6IjY1ZjA2OGQ3NDU1N2EwMDE4NTI5YzQxOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O8cfOh3PTINjr8kSQEvGb9CXiuknfjn1AR0Up7r6vZM", // Replace with your API key
                false,
                false,
                "en-US",
                1,
                "popularity.desc"
        );

        // Asynchronously execute the request
        call.enqueue(new Callback<MovieResponseDTO>() {
            @Override
            public void onResponse(Call<MovieResponseDTO> call, Response<MovieResponseDTO> response) {
                if (response.isSuccessful()) {
                    // Process the response and convert MovieDTOs
                    MovieResponseDTO movieResponseDTO = response.body();
                    if (movieResponseDTO != null) {
                        for (com.ivan.securemovieapi.dtos.MovieDTO movieDTO : movieResponseDTO.getResults()) {
                            MovieDTO filmDTO = new MovieDTO();
                            filmDTO.setTitle(movieDTO.getTitle());
                            filmDTO.setOverview(movieDTO.getOverview());
                            filmDTO.setPosterPath(movieDTO.getPosterPath());
                            filmDTO.setPopularity(movieDTO.getPopularity());
                            filmDTO.setVoteAverage(movieDTO.getVoteAverage());
                            filmDTO.setVoteCount(movieDTO.getVoteCount());
                            filmDTO.setReleaseDate(movieDTO.getReleaseDate());
                            filmDTOList.add(filmDTO);
                        }
                    }
                } else {
                    // Handle unsuccessful response
                    System.out.println("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<MovieResponseDTO> call, Throwable t) {
                // Handle failure
                t.printStackTrace();
            }
        });

        return filmDTOList;
    }


}
