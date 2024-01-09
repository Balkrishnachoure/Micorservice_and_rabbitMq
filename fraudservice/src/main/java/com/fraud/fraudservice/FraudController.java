package com.fraud.fraudservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {

	@Autowired
	FraudCheckService fraudCheckService;


	

	@GetMapping("/{customerId}")
	public FraudCheckResponse isFraudCustomer(@PathVariable Integer customerId) {
		boolean isFraud = fraudCheckService.fraudlentChecker(customerId);
         
        System.out.println("Fraud Check request for customer >> " +customerId );
		FraudCheckResponse fraudCheckResponse =new FraudCheckResponse();
		fraudCheckResponse.setFraudster(isFraud);
		return fraudCheckResponse;

	}

}
