package com.prometheus.springDemoApp.config;

import com.prometheus.springDemoApp.services.HelloWorldService;
import com.prometheus.springDemoApp.services.servicesImpl.HelloWorldServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class HelloWorldConfig {

    @Bean
    public HelloWorldServiceFactory createFacotry() {
        return new HelloWorldServiceFactory();
    }

    @Bean
    @Profile("cze")
    public HelloWorldService czechHelloWorld(HelloWorldServiceFactory helloWorldServiceFactory) {
        return helloWorldServiceFactory.createHelloWorldService("cze");
    }

    @Bean
    @Profile("eng")
    public HelloWorldService engHelloWorld(HelloWorldServiceFactory helloWorldServiceFactory) {
        return helloWorldServiceFactory.createHelloWorldService("eng");
    }

    @Bean
    @Profile({"sk","default"})
    public HelloWorldService svkHelloWorld(HelloWorldServiceFactory helloWorldServiceFactory) {
        return helloWorldServiceFactory.createHelloWorldService("svk");
    }

    @Bean
    @Primary
    @Profile("eng")
    public HelloWorldService primaryHelloWorld(HelloWorldServiceFactory helloWorldServiceFactory) {
        return helloWorldServiceFactory.createHelloWorldService("primary");
    }


}
