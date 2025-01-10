package com.RabbitMQ.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.RabbitMQ.dto.User;

@Service
public class RabbitMQJsonProducer {

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.json.key}")
	private String routingJsonKey;

	private RabbitTemplate rabbitTemplete;

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplete) {
		this.rabbitTemplete = rabbitTemplete;
	}

	public void sendJsonMessage(User user) {
		System.out.println("inside send JSON message data : " + user.toString());

		/*
		 * this rabbitMQ convert and send method is used to send the user Object to the
		 * exchange with the help of routing key
		 */
		rabbitTemplete.convertAndSend(exchange, routingJsonKey, user);
	}

}
