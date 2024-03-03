package com.example.FilmManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.FilmManagment.mapper")
public class FilmManagmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmManagmentApplication.class, args);
    }

}
