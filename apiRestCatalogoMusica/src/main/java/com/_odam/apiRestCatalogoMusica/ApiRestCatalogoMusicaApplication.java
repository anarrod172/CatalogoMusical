package com._odam.apiRestCatalogoMusica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com._odam.apiRestCatalogoMusica.modelos")
public class ApiRestCatalogoMusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestCatalogoMusicaApplication.class, args);
	}
}
