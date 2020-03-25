package edu.eci.arsw.nombreApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.nombre"})
public class nombreAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(nombreAPIApplication.class, args);
	}

}