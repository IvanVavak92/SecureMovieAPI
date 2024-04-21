package com.ivan.securemovieapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieRestController {

    private final String API_KEY = "f2aa517f266d39db80bbb00158638f88";
    private final String API_URL = "https://api.themoviedb.org/3/discover/movie";

    @GetMapping("/getMovies")
    public String getMovies() {
        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Initialize ObjectMapper for JSON parsing and serialization
        ObjectMapper objectMapper = new ObjectMapper();

        // Initialize list to store JSON objects
        List<Object> jsonResponseList = new ArrayList<>();

        // Set initial page number
        int page = 1;

        try {
            // Fetch data until reaching maximum page limit or no more data available
            while (page <= 50) {
                // Make the HTTP GET request with the provided URL, API key, and page number
                String response = restTemplate.getForObject(API_URL + "?api_key=" + API_KEY + "&page=" + page, String.class);

                // Check if the response is empty
                if (response != null && !response.isEmpty()) {
                    // Parse JSON response into an object
                    Object jsonResponse = objectMapper.readValue(response, Object.class);

                    // Add parsed JSON object to the list
                    jsonResponseList.add(jsonResponse);

                    // Increment page number for the next request
                    page++;
                } else {
                    // No more data available, break out of the loop
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions
        }

        try {
            // Serialize the list of JSON objects into a single JSON string
            String jsonResponseString = objectMapper.writeValueAsString(jsonResponseList);

            // Return the concatenated responses
            return jsonResponseString;
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; // Return an empty JSON object if serialization fails
        }
    }
}