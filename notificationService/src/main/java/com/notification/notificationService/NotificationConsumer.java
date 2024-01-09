package com.notification.notificationService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
	@Autowired
	   private  NotificationService notificationService;
        
	   // RabbitListner is very imp the moment we start the NotificationService it 
	   //should be ready to consume the messages form the Queue 
	   
	   // This Queue Comes form {spring.rabbitmq.template.default-receive-queue} 
	   // mentioned in NotificationConfig
	    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
	  // @RabbitListener(queues = "bala-test")
	    public void consumer(NotificationRequest notificationRequest) {
	      //  log.info("Consumed {} from queue", notificationRequest);
	      System.out.println("Message Consumed From Queue >> "+notificationRequest.toString());	
	        notificationService.sendNotification(notificationRequest);
	    }
}
