package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.repositories.MovieRepository;
import com.prometheus.springDemoApp.services.MovieService;
import org.springframework.stereotype.Service;


@Service//oznacuje tuto implementaciu interfejsu ako spring bean - komponent - nieco s cim vie robit spring
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    public MovieServiceImpl (MovieRepository movieRepository){ // dependency injection
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createAndAddMovie() {

        Movie movie = new Movie();
        movie.setName("superFilmJeTo");
        return movieRepository.save(movie);
    }
}
