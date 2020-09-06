package com.prometheus.springDemoApp.repositories;

import com.prometheus.springDemoApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie,Long> {


}
