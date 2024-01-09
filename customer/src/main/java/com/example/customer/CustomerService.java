package com.example.customer;

import org.springframework.http.ResponseEntity;

public interface CustomerService {

	public ResponseEntity<?> registerUser(CustomerRequest CustomerRequest);

}
