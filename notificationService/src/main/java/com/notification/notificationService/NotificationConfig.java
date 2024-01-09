package com.notification.notificationService;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
@Configuration
public class NotificationConfig {

	@Value("${spring.rabbitmq.template.exchange}")
	private String internalExchange;

	@Value("{spring.rabbitmq.template.default-receive-queue}")
	private String notificationQueue;

	@Value("{spring.rabbitmq.template.routing-key}")
	private String internalNotificationRoutingKey;

	// Define Queue Exchange and Binding Key
	public TopicExchange internalTopicExchange() 
	{    // This of Exchange we are selecting 
		return new TopicExchange(this.internalExchange) ;
	}
	
	@Bean
	public Binding internalToNotificationBinding()
	{
		return BindingBuilder.bind(notificationQueue()).
		to(internalTopicExchange()).with(this.internalNotificationRoutingKey) ;
	}
	
	
	public Queue notificationQueue()
	{
		return new Queue(this.notificationQueue ) ;
		
	}
	
	public String getInternalExchange() {
		return internalExchange;
	}

	public String getNotificationQueue() {
		return notificationQueue;
	}

	public String getInternalNotificationRoutingKey() {
		return internalNotificationRoutingKey;
	}
	

}
