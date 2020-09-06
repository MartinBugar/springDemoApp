package com.prometheus.springDemoApp.services;

import com.prometheus.springDemoApp.model.Employee;
import com.prometheus.springDemoApp.model.Todo;

public interface RestApiService {
    Todo getTodo(Long id);
}
