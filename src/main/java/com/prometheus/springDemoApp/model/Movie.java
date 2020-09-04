package com.prometheus.springDemoApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity  // to znamena ze to bude databazova tabulka s nazvom movie
public class Movie {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    Set <Director> directors = new HashSet<>();

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
        return directors;
    }

    public void setMovies(Set<Director> movies) {
        this.directors = movies;
    }
}
