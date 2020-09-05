package com.prometheus.springDemoApp;

import com.kniha.Kniha;
import com.prometheus.springDemoApp.services.AppRun;
import com.prometheus.springDemoApp.services.HelloWorldService;
import com.prometheus.springDemoApp.services.servicesImpl.PrintService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan(basePackages={"com.prometheus"})
public class SpringDemoAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoAppApplication.class, args);

        context.getBean(PrintService.class).print();

    }

}
