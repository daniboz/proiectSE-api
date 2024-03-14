package com.movieapp.MovieRecommandation.controller;

import com.movieapp.MovieRecommandation.model.Movie;
import com.movieapp.MovieRecommandation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/filtered")
    public List<Movie> getMoviesByFilters(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) String actor) {
        return movieRepository.findMoviesByFilters(genre, releaseYear, actor);
    }
}
