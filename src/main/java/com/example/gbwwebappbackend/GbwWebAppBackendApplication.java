package com.example.gbwwebappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.gbwwebappbackend.repository")
public class GbwWebAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GbwWebAppBackendApplication.class, args);
    }

}
