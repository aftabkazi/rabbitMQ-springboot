package com.RabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.RabbitMQ.dto.User;

@Service
public class RabbitMQJsonConsumer {
	
//	@RabbitListener(queues = { "${rabbitmq.queue.name}" })
//	public void consume(String message) {
//		System.out.println("inside consume method : " + message);
//	}
	
	@RabbitListener(queues= {"${rabbitmq.queue.json.name}"})
	public void consume(User user) {
		System.out.println("User object : "+user);
	}

}
