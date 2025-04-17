package com.epf.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
public class DatabaseConnectionTest {

    @Autowired
    private Environment env;

    @Test
    public void testDatabaseConnection() {
        // Afficher toutes les propriétés actives
        System.out.println("Active profiles: " + String.join(", ", env.getActiveProfiles()));
        System.out.println("Default profiles: " + String.join(", ", env.getDefaultProfiles()));
        
        // Afficher les propriétés de connexion
        System.out.println("URL: " + env.getProperty("spring.datasource.url"));
        System.out.println("Username: " + env.getProperty("spring.datasource.username"));
        System.out.println("Password defined: " + (env.getProperty("spring.datasource.password") != null));
        System.out.println("Driver: " + env.getProperty("spring.datasource.driver-class-name"));
    }
}
