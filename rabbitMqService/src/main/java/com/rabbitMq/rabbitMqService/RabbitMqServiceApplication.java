package com.rabbitMq.rabbitMqService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.rabbitMq.rabbitMqService")
public class RabbitMqServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqServiceApplication.class, args);
	}

}
