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
import java.util.stream.Collectors;


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
        return movieRepository.findAll().stream()
                .map(movie -> movieMapper.movieToMovieDTO(movie))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> findMovieByName(String name) {
        return movieRepository.findByName(name).stream().map(movie ->  movieMapper.movieToMovieDTO(movie))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        return movieMapper.movieToMovieDTO(movieRepository.save(movieMapper.movieDtoToMovie(movieDTO)));
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO, long movieId) {
       return movieMapper.movieToMovieDTO(  movieRepository.findById(movieId)
                .map(movie -> {
                            movie.setName(movieDTO.getName());
                            movie.setDirectors(movieDTO.getDirectorsOfTheMovie());
                            return movieRepository.save(movie);
                        }
                ).orElseGet( () -> {
//                            movieDTO.setId(movieId);
                            return movieRepository.save(movieMapper.movieDtoToMovie(movieDTO));
                        }
                       )
                );
    }

    @Override
    public void deleteMovie(long id) {
        movieRepository.deleteById(id);
    }


}

