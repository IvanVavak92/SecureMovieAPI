package com.ivan.securemovieapi.services;

import com.ivan.securemovieapi.dtos.MovieResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MovieServiceApi {

    @GET("movie")
    Call<MovieResponseDTO> fetchMovies(@Query("query") String title, @Header("accept") String acceptValue, @Header("Authorization") String key);

}
