package com.prometheus.springDemoApp.restApi;

import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;
import com.prometheus.springDemoApp.repositories.MovieRepository;
import com.prometheus.springDemoApp.services.MovieService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;




import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    List<MovieDTO> getMovies(@RequestParam(required = false) String name) {

        if (name != null && !name.isEmpty()) {
            return movieService.findMovieByName(name);
        } else
            return movieService.getAllMovies();
    }


    @GetMapping("/movies/{id}")
   EntityModel<MovieDTO> getMovieById(@PathVariable("id") long movieId) {
        MovieDTO movieDTO = movieService.getMovieById(movieId);

        return new EntityModel<>(movieDTO
                ,linkTo(methodOn(MovieController.class).getMovieById(movieId)).withSelfRel()
                ,linkTo(methodOn(MovieController.class).getMovies("")).withRel("movies")) ;
    }

    @PostMapping("/movies")
    MovieDTO addMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @PutMapping("/movies/{id}")
    MovieDTO updateMovie (@RequestBody MovieDTO movieDTO, @PathVariable("id") long movieId){
        return movieService.updateMovie(movieDTO, movieId);
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable long id){
        movieService.deleteMovie(id);
    }


}
