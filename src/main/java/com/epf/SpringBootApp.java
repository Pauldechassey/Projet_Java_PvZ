package com.epf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class SpringBootApp extends SpringBootServletInitializer {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
