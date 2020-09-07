package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.model.Employee;
import com.prometheus.springDemoApp.model.Todo;
import com.prometheus.springDemoApp.model.TodoList;
import com.prometheus.springDemoApp.services.RestApiService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RestApiServiceImpl implements RestApiService {

    RestTemplate restTemplate;

    public RestApiServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public RestApiServiceImpl() {

    }


    @Override
    public Todo getTodo(Long id) {
//        RestTemplate restTemplate = new RestTemplate();

        Todo todo = restTemplate.getForObject("http://jsonplaceholder.typicode.com/todos/1",Todo.class);
        return todo ;
    }

    @Override
    public List<Todo> getTodos() {
//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Todo>> responseEntity = restTemplate.exchange(
                "http://jsonplaceholder.typicode.com/todos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {}
        );

       List<Todo> todos = responseEntity.getBody();
        return todos ;
    }


    // tento sposob ide len ked je nejaky objekt este navrchu ostatnych objektov
    @Override
    public TodoList getTodoList() {
        RestTemplate restTemplate = new RestTemplate();
        TodoList todoList = restTemplate.getForObject("http://jsonplaceholder.typicode.com/todos", TodoList.class);
        return todoList;
    }

    public static void main(String[] args) {

        RestApiServiceImpl restApiService = new RestApiServiceImpl();

//        Todo todo = restApiService.getTodo(1L);
//        System.out.println(todo.getId());
 //       System.out.println(restApiService.getTodoList());
    }


}
