package com.ivan.securemovieapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieRestController {

    @Value("${api.key}")
    private String apiKey;
    private final String BASE_API_URL = "https://api.themoviedb.org/3/";

    private String fetchDataFromApi(String endpoint) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        List<Object> jsonResponseList = new ArrayList<>();

        int page = 1;

        try {
            while (page <= 10) {
                String response = restTemplate.getForObject(BASE_API_URL + endpoint + "?api_key=" + apiKey + "&page=" + page, String.class);

                if (response != null && !response.isEmpty()) {
                    Object jsonResponse = objectMapper.readValue(response, Object.class);
                    jsonResponseList.add(jsonResponse);
                    page++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            return objectMapper.writeValueAsString(jsonResponseList);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    @GetMapping("/getMovies")
    public String getMovies() {
        return fetchDataFromApi("discover/movie");
    }

    @GetMapping("/getTopRatedMovies")
    public String getTopRatedMovies() {
        return fetchDataFromApi("movie/top_rated");
    }

    @GetMapping("/trending")
    public String trending() {
        return fetchDataFromApi("trending/all/day");
    }
}

