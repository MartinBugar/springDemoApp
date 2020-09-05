package com.prometheus.springDemoApp;

import com.prometheus.springDemoApp.services.AppRun;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(SpringDemoAppApplication.class, args);

		AppRun appRun = context.getBean(AppRun.class);
		appRun.run();


	}

}
