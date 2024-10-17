package com.clovdev.spring_client_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringClientCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClientCrudApplication.class, args);
    }

}
