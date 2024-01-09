package com.rabbitMq.rabbitMqService;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class RabbitMqConfig {

	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jacksonConverter());
		return rabbitTemplate;
	}

	// Setting up Listner
	@Bean
	public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(jacksonConverter());
		return factory;

	}

	@Bean
	public MessageConverter jacksonConverter() {
		// To send the Messages from Producer in Json format
		MessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
		return jackson2JsonMessageConverter;
	}

	@Bean
	ConnectionFactory connectionFactory() {
		return new CachingConnectionFactory();
	}

}
