package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.services.HelloWorldService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimaryHelloWorld implements HelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("ahoj z primary");
    }
}
