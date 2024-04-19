package com.ivan.securemovieapi.services;

import com.ivan.securemovieapi.dtos.MovieResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MovieServiceApi {

    @GET("discover/movie")
    Call<MovieResponseDTO> getPopularMovies(
            @Header("Authorization") String authorization,
            @Query("include_adult") boolean includeAdult,
            @Query("include_video") boolean includeVideo,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );
}
