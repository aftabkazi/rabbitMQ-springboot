package com.RabbitMQ.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

	/*
	 * create a rabbit template to send messages Spring boot automatically
	 * configures Rabbit Template for us. We need to inject it and use it
	 */

	// constructor based injection to inject Rabbit Template
	private RabbitTemplate rabbitTemplate;

	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String message) {
		logger.info(String.format("Message send-> %s",message));
		System.out.println("Message Send");
		
		/*
		 * This method convertAndSend uses three parameters where with the help of rouring key 
		 * message will be send to the exchange
		 * 1) Exchange - exchange name
		 * 2) Routing key - name of the routing key
		 * 3) message - actual message that we want to pass
		 */
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}

}
