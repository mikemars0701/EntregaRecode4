package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo.services")
public class SpacebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacebookApplication.class, args);
	}

}
