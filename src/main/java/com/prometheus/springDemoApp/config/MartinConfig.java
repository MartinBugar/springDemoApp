package com.prometheus.springDemoApp.config;

import com.prometheus.springDemoApp.services.servicesImpl.PrintService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:martin.properties"),
        @PropertySource("classpath:bugar.properties")
})

public class MartinConfig {

    @Value("${martin.meno}")
    String meno;

    @Value("${martin.priezvisko}")
    String priezvisko;

    @Bean
    public PrintService printService(){
        PrintService printService = new PrintService();
        printService.setData(meno + ", " + priezvisko);
        return printService;
    }

}
