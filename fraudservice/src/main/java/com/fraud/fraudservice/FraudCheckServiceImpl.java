package com.fraud.fraudservice;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudCheckServiceImpl  implements FraudCheckService {
	
	@Autowired 
	FraudCheckRepo fraudCheckRepo ;
	
	public boolean fraudlentChecker(int customerId)
	{
		
		// Use Builder Pattern at it place .
		FraudCheckHistory fraudCheckHistory = new FraudCheckHistory() ;
		fraudCheckHistory.setCustomerId(customerId);
		fraudCheckHistory.setFraudster(false);
		fraudCheckHistory.setCreatedAt(LocalDateTime.now());
		fraudCheckRepo.save(fraudCheckHistory) ;
		return false ;
		
	}
	

}
