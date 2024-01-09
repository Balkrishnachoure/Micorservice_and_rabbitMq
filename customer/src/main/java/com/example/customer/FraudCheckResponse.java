package com.example.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudCheckResponse {
	
	private boolean isFraudster ;

	public boolean isFraudster() {
		return isFraudster;
	}

	public void setFraudster(boolean isFraudster) {
		this.isFraudster = isFraudster;
	}
	
	
	

}
