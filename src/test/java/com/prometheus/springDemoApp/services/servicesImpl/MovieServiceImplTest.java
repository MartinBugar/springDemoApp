package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;
import com.prometheus.springDemoApp.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
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

    @Test
    @Transactional
    public void movieFromServicesAreSame (){

        Movie movie1 = new Movie();
        movie1.setName("superFilmJeTo");
        movie1.setId(1L);

        Movie movie2 = new Movie();
        movie2.setName("superFilmJeTo");
        movie2.setId(2L);


        List<MovieDTO> moviesDTO = movieService.getAllMovies();

        assertEquals(movie1.getId(), moviesDTO.get(0).getId());
        assertEquals(movie2.getId(), moviesDTO.get(1).getId());

        assertEquals(movie1.getName(), moviesDTO.get(0).getName());
        assertEquals(movie2.getName(), moviesDTO.get(1).getName());
    }

    @Test
    @Transactional
    public void movieFromDBFindByName(){
        List<MovieDTO> movieDTO = movieService.findMovieByName("superFilmJeTo");
        assertEquals(movieDTO.get(0).getName(),"superFilmJeTo");
        assertEquals(movieDTO.get(1).getName(),"superFilmJeTo");
    }

}