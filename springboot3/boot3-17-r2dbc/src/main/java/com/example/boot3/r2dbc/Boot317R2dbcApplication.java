package com.example.boot3.r2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class Boot317R2dbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot317R2dbcApplication.class, args);
    }

}
