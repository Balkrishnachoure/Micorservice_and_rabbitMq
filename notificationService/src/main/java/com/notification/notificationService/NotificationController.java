package com.notification.notificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notify")
public class NotificationController {
   
	
	@Autowired
	NotificationService notificationService ;
	
	@PostMapping("/notification"  )
	public void sendNotification(@RequestBody NotificationRequest notificationRequest )
	{
		notificationService.sendNotification(notificationRequest) ;
	}
	
}
