package com.example.boot3.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class Boot312MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot312MessageApplication.class, args);
    }

}
