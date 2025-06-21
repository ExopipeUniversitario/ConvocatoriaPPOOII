package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {
        "com.example.controllers",
        "com.example.services",
        "com.example.repositories",
        "com.example.models"
    })
@EntityScan(basePackages = {"com.example.models"})
@EnableJpaRepositories(basePackages = {"com.example.repositories"})
public class PpooiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpooiiApplication.class, args);
	}

}
