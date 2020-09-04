package com.prometheus.springDemoApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppRun {

    @Autowired
    MovieService movieService;

    public void run(){
        movieService.createAndAddMovie();
    }
}
