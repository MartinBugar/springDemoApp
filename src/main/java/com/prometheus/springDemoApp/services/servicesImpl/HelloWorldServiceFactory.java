package com.prometheus.springDemoApp.services.servicesImpl;

import com.prometheus.springDemoApp.services.HelloWorldService;

public class HelloWorldServiceFactory {

    public HelloWorldService createHelloWorldService (String language){
        switch (language){
            case "eng" :
                return new EnglishHelloWorld();
            case "cze" :
                return new CzechHelloWorld();
            case "svk" :
                return new SlovakHelloWorld();
            default:
                return new PrimaryHelloWorld();
        }
    }
}
