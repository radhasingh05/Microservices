package com.radha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringActuatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringActuatorServiceApplication.class, args);
	}

}
