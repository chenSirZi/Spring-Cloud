package com.example.microserviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 申明为EurekaServer
@EnableEurekaServer
public class MicroserviceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEurekaApplication.class, args);
	}
}
