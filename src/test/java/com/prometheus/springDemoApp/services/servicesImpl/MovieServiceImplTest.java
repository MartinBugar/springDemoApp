package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;
import com.prometheus.springDemoApp.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceImplTest {

    @Autowired
    MovieService movieService;



    @Test
    @Transactional // ked sa pristupuje k databaze
    public void movieToServiceToDtoIsSame(){
        Movie movie = new Movie();
        movie.setName("superFilmJeTo");
        movie.setId(1L);


        MovieDTO movieDTO = movieService.getMovieById(1L); // vytiahne mi z databazy
        assertEquals(movie.getName(), movieDTO.getName());
        assertEquals(movie.getId(), movieDTO.getId());
    }

}