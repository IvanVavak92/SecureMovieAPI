package com.ivan.securemovieapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {

    private final String API_KEY = "f2aa517f266d39db80bbb00158638f88";
    private final String API_URL = "https://api.themoviedb.org/3/tv/top_rated";

    @GetMapping("/getMovie")
    public String getMovie() {
        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make the HTTP GET request with the provided URL and API key
        String response = restTemplate.getForObject(API_URL + "?api_key=" + API_KEY, String.class);

        // Return the response from the API
        return response;
    }
}
