package com.ivan.securemovieapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // it exclude login
public class SecureMovieApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureMovieApiApplication.class, args);
    }

}
