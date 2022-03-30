package com.yaydoo.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.yaydoo.examen.model")
@OpenAPIDefinition(info = @Info(title = "YAYDOO", version = "1.0", description = "APIS  para el examen de YAYDOO por Alan Martinez."))
public class ExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}
	
	

}
