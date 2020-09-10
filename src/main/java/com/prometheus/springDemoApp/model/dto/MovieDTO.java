package com.prometheus.springDemoApp.model.dto;

import com.prometheus.springDemoApp.model.Director;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.Set;

public class MovieDTO extends RepresentationModel<MovieDTO> {
    private Long id;
    private String name;
    Set<Director> directorsOfTheMovie = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Director> getDirectorsOfTheMovie() {
        return directorsOfTheMovie;
    }

    public void setDirectorsOfTheMovie(Set<Director> directorsOfTheMovie) {
        this.directorsOfTheMovie = directorsOfTheMovie;
    }
}
