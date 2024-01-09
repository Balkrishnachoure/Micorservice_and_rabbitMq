package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rabbitMq.rabbitMqService.RabbitMqMessageProducer;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	FraudClient fraudClient;
	
	@Autowired
	private  RabbitMqMessageProducer rabbitMqMessageProducer ;
	
	//@Autowired
	//private NotificationClient notificationClient ;
	
	

	@Override
	public ResponseEntity<?> registerUser(CustomerRequest customerRequest) {
		Customer customer = new Customer();

		// Try to make it by Builder
		customer.setFirstName(customerRequest.getFirstName());
		customer.setLastname(customerRequest.getLastName());
		customer.setEmail(customerRequest.getEmail());

		// To check if email id is vaild or not
		// Check if email is not taken
		// Check if fraud
		// if fraud then send notification
		Customer customerSaveResponse = customerRepo.saveAndFlush(customer);

//		     FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD-SERVICE/api/v1/fraud-check/{customerId}",
//					FraudCheckResponse.class,customer.getId() ) ;
//			
        // Feign Client 
		FraudCheckResponse fraudCheckResponse = fraudClient.isFraudCustomer(customer.getId());

		if (fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("Fraudster");
		}
		
		
		// To send notification : Send request form customer to fraud if customer is not a fraud then 
		// then send the notification to customer 
		
//		 send notification with rest template
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<NotificationRequest> httpEntity = new HttpEntity<>(
//				NotificationRequest.builder()
//				.toCustomerId(saveCustomer.getId())
//				.toCustomerEmail(saveCustomer.getEmail())
//				.message(String.format("Hi %s, welcome to abcprivates...!", saveCustomer.getName()))
//				.build(),
//				httpHeaders
//				);
//		
//		restTemplate.postForLocation(
//				"http://localhost:8082/notification",
//				httpEntity
//				);
		 
//		 send notification with feign client
//		 notificationClient.sendNotification(
//				 NotificationRequest.builder()
//					.toCustomerId(saveCustomer.getId())
//					.toCustomerEmail(saveCustomer.getEmail())
//					.message(String.format("Hi %s, welcome to abcprivates...!", saveCustomer.getName()))
//					.build(),
//					SharedData.getSharedDataMap().get("jwtToken")
//				 );

		
	
		//SENDING ASYNC NOTIFICATION WITH RABBITMQ
		
		NotificationRequest notificationRequest = new NotificationRequest(
			customer.getId() ,
			customer.getEmail(),
			String.format("Welcome to rabit MQ", customer.getFirstName())
				) ;
		  
		System.out.println("NotificationRequest Values :" +notificationRequest.toString() );
		rabbitMqMessageProducer.publish(notificationRequest,"internal.exchange","internal.notification.routing-key");
		
		

		return new ResponseEntity<>(customerSaveResponse, HttpStatus.OK);

	}

}
