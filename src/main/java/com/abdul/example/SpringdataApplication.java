package com.abdul.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.abdul.example.*")
public class SpringdataApplication {

	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/abdul");
		SpringApplication.run(SpringdataApplication.class, args);
	}

}
