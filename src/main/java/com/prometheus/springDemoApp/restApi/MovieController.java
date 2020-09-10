package com.prometheus.springDemoApp.restApi;

import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;
import com.prometheus.springDemoApp.repositories.MovieRepository;
import com.prometheus.springDemoApp.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    List<MovieDTO> getMovies(@RequestParam(required = false) String name){

        if (name != null && !name.isEmpty()){
            return movieService.findMovieByName(name);
        } else
        return movieService.getAllMovies();
    }



    @GetMapping("/movies/{id}")
    MovieDTO getMovieById(@PathVariable("id") long movieId){
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/movies")
    MovieDTO addMovie (@RequestBody MovieDTO movieDTO){
            return movieService.addMovie(movieDTO);
        }

}
