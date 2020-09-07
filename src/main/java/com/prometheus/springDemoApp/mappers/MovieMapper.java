package com.prometheus.springDemoApp.mappers;


import com.prometheus.springDemoApp.model.Movie;
import com.prometheus.springDemoApp.model.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "directorsOfTheMovie", source = "directors")
    MovieDTO movieToMovieDTO(Movie movie);
}
