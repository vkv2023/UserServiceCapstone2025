package com.user.UserServiceCapstone2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.user.UserServiceCapstone2025.service")
@EnableJpaAuditing
public class UserServiceCapstone2025Application {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceCapstone2025Application.class, args);
	}

}
