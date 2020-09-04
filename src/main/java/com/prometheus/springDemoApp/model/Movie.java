package com.prometheus.springDemoApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity  // to znamena ze to bude databazova tabulka s nazvom movie
public class Movie {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    Set <Director> movies = new HashSet<>();

    public Movie (){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Director> getMovies() {
        return movies;
    }

    public void setMovies(Set<Director> movies) {
        this.movies = movies;
    }
}
