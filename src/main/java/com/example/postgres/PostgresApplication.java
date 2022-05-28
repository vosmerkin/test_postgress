package com.example.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

@SpringBootApplication
public class PostgresApplication {

	public static void main(String[] args) {
		Locale.setDefault( new Locale("en", "US"));
		SpringApplication.run(PostgresApplication.class, args);
//		ConfigurableApplicationContext context =SpringApplication.run(PostgresApplication.class, args);
	}

}
