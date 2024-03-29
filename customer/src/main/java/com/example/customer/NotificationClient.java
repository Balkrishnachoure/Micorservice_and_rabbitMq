package com.example.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name =  "Notification-Service")
public interface NotificationClient {
	
	@PostMapping("/notification")
	public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}