package com.tutorial.java.java21;

import com.tutorial.java.java21.service.InitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Java21Application {

    @Autowired
    private InitDataService initDataService;

    public static void main(String[] args) {
        SpringApplication.run(Java21Application.class, args);
    }

    @Bean
    CommandLineRunner startup() {
        return args -> {
            initDataService.loadData();

        };
    }

}
