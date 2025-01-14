package com.RabbitMQ.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	/*
	 * @RabitListner annotation = this annotation is used to read/consume message
	 * from the queue whose name is passed as the attribute of the annotation
	 * basically, this consume method is subscribed to queue(whose name is passed in
	 * the parameter) with the help of @RabbitListner annotation
	 * 
	 */
//	@RabbitListener(queues = { "${rabbitmq.queue.name}" })
//	public void consume(String message) {
//		System.out.println("inside consume method : " + message);
//	}

}
