package com.example.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

	// Creating Resttemplate bean
	@Bean
	@LoadBalanced  // To handle the Unknown host Exception we need @LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
