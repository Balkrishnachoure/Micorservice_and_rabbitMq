package com.rabbitMq.rabbitMqService;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMqMessageProducer {

	private AmqpTemplate amqpTemplate;
	
	 public RabbitMqMessageProducer(AmqpTemplate amqpTemplate) {
	        this.amqpTemplate = amqpTemplate;
	    }

	public void publish(Object payload, String exchange, String routingKey) {

		// Pay load is the Object ..
		System.out.println("Publishing To using Routing Key : " + exchange + " " + " " + payload.toString() + " " + routingKey);

		amqpTemplate.convertAndSend(exchange, routingKey, payload);

		System.out.println("Published To using Routing Key : " + exchange + " " + " " + payload + " " + routingKey);

	}

}
