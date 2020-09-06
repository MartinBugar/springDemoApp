package com.prometheus.springDemoApp.services;

import com.prometheus.springDemoApp.model.Employee;
import com.prometheus.springDemoApp.model.Todo;
import com.prometheus.springDemoApp.model.TodoList;

import java.util.List;

public interface RestApiService {
    Todo getTodo(Long id);
    List <Todo> getTodos();

    TodoList getTodoList();
}
