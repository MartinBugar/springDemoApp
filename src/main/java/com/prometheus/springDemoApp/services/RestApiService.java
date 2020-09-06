package com.prometheus.springDemoApp.services;

import com.prometheus.springDemoApp.model.Employee;
import com.prometheus.springDemoApp.model.Todo;

import java.util.List;

public interface RestApiService {
    Todo getTodo(Long id);
    List <Todo> getTodos();
}
