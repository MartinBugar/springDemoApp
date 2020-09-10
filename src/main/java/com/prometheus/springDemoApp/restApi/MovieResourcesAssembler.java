package com.prometheus.springDemoApp.restApi;

import com.prometheus.springDemoApp.model.dto.MovieDTO;
import com.prometheus.springDemoApp.restApi.MovieController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class MovieResourcesAssembler implements RepresentationModelAssembler <MovieDTO, EntityModel<MovieDTO>> {
    @Override
    public EntityModel<MovieDTO> toModel(MovieDTO movieDTO) {
        return new EntityModel<>(movieDTO
                ,linkTo(methodOn(MovieController.class).getMovieById(movieDTO.getId())).withSelfRel()
                ,linkTo(methodOn(MovieController.class).getMovies("")).withRel("movies")) ;
    }
}
