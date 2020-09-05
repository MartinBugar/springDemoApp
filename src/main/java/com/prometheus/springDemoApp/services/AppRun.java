package com.prometheus.springDemoApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppRun {

    //    @Autowired  1. sposob dependency injection
    MovieService movieService;

//    @Autowired // ked je tam tato anotacia nemusi sa robit dependency injection cez konstruktor, ale moze sa... 2. sposob dependency injection
//    public AppRun (MovieService movieService){
//        this.movieService = movieService;
//    }

    @Autowired // 3. sposob dependency injection
    public void setMovieService(MovieService movieService){
        this.movieService = movieService;
    }


    public void run(){
        movieService.createAndAddMovie();
    }
}
