package com.example.customer;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name ="FRAUD-SERVICE")
@LoadBalancerClient(name ="FRAUD-SERVICE") // @LoadBalancerClient is must otherwise you can get exception
// @FeignClient(value ="FRAUD" ,path="api/v1/fraud-check")
public interface FraudClient {
	
	@GetMapping("api/v1/fraud-check/{customerId}")
	public FraudCheckResponse isFraudCustomer(@PathVariable Integer customerId) ;

	
}



