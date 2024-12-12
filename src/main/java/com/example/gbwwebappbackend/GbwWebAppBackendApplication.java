package com.example.gbwwebappbackend;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class GbwWebAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GbwWebAppBackendApplication.class, args);
    }

}
