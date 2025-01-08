package com.RabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	/*
	 * In This class we have created three different methods
	 * 1) Queue ( where queue name is defined)
	 * 2) Exchange( where exchange name is defined) 
	 * 3) Routing key (Where routing is defined where which queue is used to which exchange)
	 */

	@Value("${rabbitmq.queue.name}")
	private String queueName;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routing;

	// spring bean for rabbit MQ Queue
	// use queue as return type from org.springframework.amqp.core.Queue; package
	@Bean
	public Queue queue() {
		// defining QueueName from application.properties file
		return new Queue(queueName);
	}

	// create bean of exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	// create a binding with queue binding with exchange using routing key
	@Bean
	public Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(exchange())
				.with(routing);
	}
	
	/*
	 * Apart from this we need to Configure below these three beans
	 * 	1) connection factory
	 * 	2) rabbit template
	 * 	3) Rabbit Admin
	 * 
	 * but spring boot auto configure all these above three beans so
	 * we don't need to manually configure all the above three beans
	 */
	

}
