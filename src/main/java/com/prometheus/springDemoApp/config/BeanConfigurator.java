package com.prometheus.springDemoApp.config;

import com.kniha.Kniha;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfigurator {

    @Bean
    public Kniha createKniha (){
        return new Kniha();
    }

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
