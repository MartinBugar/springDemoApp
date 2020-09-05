package com.prometheus.springDemoApp.config;

import com.kniha.Kniha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurator {

    @Bean
    public Kniha createKniha (){
        return new Kniha();
    }

}
