package com.fraud.fraudservice;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FraudCheckResponse {

	 private boolean isFraudster ;

	public boolean isFraudster() {
		return isFraudster;
	}

	public void setFraudster(boolean isFraudster) {
		this.isFraudster = isFraudster;
	}
	 
	 
	
}
