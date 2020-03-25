package edu.eci.arsw.CoronavirusApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.Coronavirus"})
public class CoronavirusAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusAPIApplication.class, args);
	}

}