package com.prometheus.springDemoApp.restApi;

import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.repositories.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
   MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    List<Movie> getAll (){
        return movieRepository.findAll();
    }
}
