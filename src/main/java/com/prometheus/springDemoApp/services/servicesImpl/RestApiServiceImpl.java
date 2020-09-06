package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.model.Employee;
import com.prometheus.springDemoApp.model.Todo;
import com.prometheus.springDemoApp.services.RestApiService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestApiServiceImpl implements RestApiService {
    @Override
    public Todo getTodo(Long id) {

//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
//        messageConverters.add(converter);

        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setMessageConverters(messageConverters);

//        Employee employee = restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employee/1", Employee.class);
        Todo todo = restTemplate.getForObject("http://jsonplaceholder.typicode.com/todos/1",Todo.class);
        return todo ;
    }

    public static void main(String[] args) {
        RestApiServiceImpl restApiService = new RestApiServiceImpl();
        Todo todo = restApiService.getTodo(1L);
        System.out.println(todo.getId());
    }
}
