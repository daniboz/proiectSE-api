package com.movieapp.MovieRecommandation.repository;

import com.movieapp.MovieRecommandation.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE (:genre IS NULL OR m.genre = :genre) AND (:releaseYear IS NULL OR m.releaseYear = :releaseYear) AND (:actor IS NULL OR m.actor = :actor)")
    List<Movie> findMoviesByFilters(@Param("genre") String genre, @Param("releaseYear") Integer year, @Param("actor") String actor);
}
