package ru.charov.mctwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class MctwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MctwoApplication.class, args);
    }

}
