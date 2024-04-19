package com.ivan.securemovieapi.dtos;

import java.util.List;

public class MovieResponseDTO {

    private int page;
    private List<MovieDTO> results;
    public MovieResponseDTO() {
    }

    public MovieResponseDTO(int page, List<MovieDTO> results) {
        this.page = page;
        this.results = results;
    }

    // Getters and setters
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieDTO> getResults() {
        return results;
    }

    public void setResults(List<MovieDTO> results) {
        this.results = results;
    }
}

