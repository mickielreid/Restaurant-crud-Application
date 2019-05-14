package com.mic.luxemain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LuxemainApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuxemainApplication.class, args);
	}

}
