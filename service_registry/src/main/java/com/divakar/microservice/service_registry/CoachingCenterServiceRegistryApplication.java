package com.divakar.microservice.service_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CoachingCenterServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachingCenterServiceRegistryApplication.class, args);
	}

}
