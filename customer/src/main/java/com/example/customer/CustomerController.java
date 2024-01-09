package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.PostLoad;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService ;
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<?> registerCustomer( @RequestBody  CustomerRequest  CustomerRequest )
	{
		return new ResponseEntity<>(customerService.registerUser(CustomerRequest),HttpStatus.OK) ;	
	}
	
	
	

}
