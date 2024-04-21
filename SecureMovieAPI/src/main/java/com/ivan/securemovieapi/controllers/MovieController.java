package com.ivan.securemovieapi.controllers;

import com.ivan.securemovieapi.models.Movie;
import com.ivan.securemovieapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    private boolean queryTrigger = false;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("myMovies", movieService.getMyMovies());
        model.addAttribute("queryTrigger", this.queryTrigger);
        return "search";
    }

    @GetMapping("/search-movie")
    public String searchMovies(@RequestParam(required = false, defaultValue = "") String query, Model model) {
        this.queryTrigger = true;
        List<Movie> myMovies = movieService.findByTitle(query);
        model.addAttribute("queryTrigger", this.queryTrigger);
        model.addAttribute("myMovies", myMovies);
        return "search";
    }
}
