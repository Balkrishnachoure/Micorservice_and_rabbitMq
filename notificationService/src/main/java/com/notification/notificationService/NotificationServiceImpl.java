package com.notification.notificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl  implements NotificationService{

	@Autowired
	NotificationRepo notificationRepo;

	public void sendNotification(NotificationRequest notificationRequest) {

// Builder Pattern 		
//		notificationRepository.save(
//				Notification.builder()
//				.toCustomerId(notificationRequest.getToCustomerId())
//				.toCustomerEmail(notificationRequest.getToCustomerEmail())
//				.sender("Nassprivates")
//				.message(notificationRequest.getMessage())
//				.build()
//				);
//		

		Notification notification = new Notification();
		notification.setToCustomerId(notificationRequest.getToCustomerId());
		notification.setToCustomerEmail(notificationRequest.getToCustomerEmail());
		notification.setSender(notificationRequest.getSender());
		notification.setMessage(notificationRequest.getMessage());
		notification.setSentAt(notificationRequest.getSentAt());

		notificationRepo.save(notification);

	}

}
