package com.ivan.securemovieapi.services.impl;

import com.ivan.securemovieapi.dtos.MovieResponseDTO;
import com.ivan.securemovieapi.models.Movie;
import com.ivan.securemovieapi.repositories.MovieRepository;
import com.ivan.securemovieapi.services.MovieService;
import com.ivan.securemovieapi.services.MovieServiceApi;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    List<Movie> myMovies;

    private Retrofit retrofit;
    private MovieServiceApi movieApi;

    private final String key = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMmFhNTE3ZjI2NmQzOWRiODBiYmIwMDE1ODYzOGY4OCIsInN1YiI6IjY1ZjA2OGQ3NDU1N2EwMDE4NTI5YzQxOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mj-WR98Z_JGYxxUgo34CvTnDaEgpjTVHD39SIkoVVEY";
    private final String acceptValue = "application/json";

    // dependencies
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository, MovieRepository movieRepository1) {
        this.movieRepository = movieRepository1;
        this.myMovies = new ArrayList<>();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieApi = retrofit.create(MovieServiceApi.class);
    }


    // methods
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> getMyMovies() {
        return myMovies;
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findAllByTitleContainingIgnoreCase(title);
    }


    @Override
    public MovieResponseDTO getMovies(String title) {
        Call<MovieResponseDTO> fetchData = movieApi.fetchMovies(title, acceptValue, key);
        MovieResponseDTO result = null;

        try {
            Response<MovieResponseDTO> tryFetchData = fetchData.execute();
            if(tryFetchData.isSuccessful()  && tryFetchData.body() !=null){
                result = tryFetchData.body();
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public void setMyMovies(List<Movie> myMovies) {
        this.myMovies = myMovies;
    }

}
