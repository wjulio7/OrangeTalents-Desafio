package com.example.vacinaja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication   (exclude = { SecurityAutoConfiguration.class })
public class VacinaJaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacinaJaApplication.class, args);
	}

}
