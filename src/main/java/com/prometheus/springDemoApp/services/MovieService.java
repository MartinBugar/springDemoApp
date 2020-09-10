package com.prometheus.springDemoApp.services;

import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;

import java.util.List;


public interface MovieService {

    Movie createAndAddMovie();

    MovieDTO getMovieById(Long id);

    List <MovieDTO> getAllMovies();

    List<MovieDTO> findMovieByName(String name);

    MovieDTO addMovie (MovieDTO movieDTO);

    MovieDTO updateMovie(MovieDTO movieDTO, long movieId);
}
