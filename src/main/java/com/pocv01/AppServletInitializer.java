package com.pocv01;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.SpringApplication;

public class AppServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);  // App is your main Spring Boot application class
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
