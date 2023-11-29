package com.springboot.backend.app.computers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SprinbootEurekaServerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinbootEurekaServerBackendApplication.class, args);
	}

}
