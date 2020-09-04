package com.prometheus.springDemoApp.repositories;

import com.prometheus.springDemoApp.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository <Movie,Long> {


}
