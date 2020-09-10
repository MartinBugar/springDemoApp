package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.mappers.MovieMapper;
import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;
import com.prometheus.springDemoApp.repositories.MovieRepository;
import com.prometheus.springDemoApp.services.MovieService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service//oznacuje tuto implementaciu interfejsu ako spring bean - komponent - nieco s cim vie robit spring
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    MovieMapper movieMapper;

    public MovieServiceImpl (MovieRepository movieRepository, MovieMapper movieMapper){ // dependency injection
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createAndAddMovie() {

        Movie movie = new Movie();
        movie.setName("superFilmJeTo");
        return movieRepository.save(movie);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        return movieMapper.movieToMovieDTO(movieRepository.findById(id).orElse(null));
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return null;
    }

    @Override
    public MovieDTO findMovieByName(String name) {
        return null;
    }
}
