package com.prometheus.springDemoApp.mappers;

import com.prometheus.springDemoApp.model.Director;
import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MovieMapperTest {

    @Test
    public void movieToMovieDtoIsSame(){
        Movie movie = new Movie();
        movie.setName("Fireproof");
        movie.setId(1L);
        Set<String> set = new HashSet<>();
        set.add("Alec Kendrick");

        MovieDTO movieDto = MovieMapper.INSTANCE.movieToMovieDTO(movie);
        assertEquals(movie.getId(), movieDto.getId());
        assertEquals(movie.getName(),movieDto.getName());
        assertArrayEquals(movie.getDirectors().toArray(),movieDto.getDirectorsOfTheMovie().toArray() );

    }

}