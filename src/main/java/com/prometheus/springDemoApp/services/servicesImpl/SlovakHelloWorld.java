package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.services.HelloWorldService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("eng")
public class SlovakHelloWorld implements HelloWorldService {
    @Override
    public void sayHello() {

    }
}
