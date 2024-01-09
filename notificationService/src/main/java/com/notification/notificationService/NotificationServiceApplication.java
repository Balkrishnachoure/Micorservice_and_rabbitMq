package com.notification.notificationService;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.rabbitMq.rabbitMqService.RabbitMqConfig;

@SpringBootApplication(scanBasePackages = { "com.notification.notificationService", "com.rabbitMq.rabbitMqService" })
@EnableRabbit
@Import(RabbitMqConfig.class)
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

// RabbitMq Service ki jar banke hume notification service me dalna hai only

//  @Bean
//  CommandLineRunner commandLineRunner(
//          RabbitMqMessageProducer producer,
//          NotificationConfig notificationConfig
//          ) {
//      return args -> {
//          producer.publish(
//                  "Foo",
//                  notificationConfig.getInternalExchange(),
//                  notificationConfig.getInternalNotificationRoutingKey());
//      };
//  }

}
