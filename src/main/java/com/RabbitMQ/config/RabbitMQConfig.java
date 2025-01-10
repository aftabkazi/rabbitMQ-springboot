package com.RabbitMQ.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	/*
	 * In This class we have created three different methods 1) Queue ( where queue
	 * name is defined) 2) Exchange( where exchange name is defined) 3) Routing key
	 * (Where routing is defined where which queue is used to which exchange)
	 */

	@Value("${rabbitmq.queue.name}")
	private String queueName;

	@Value("${rabbitmq.queue.json.name}")
	private String jsonQueue;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routing;

	@Value("${rabbitmq.routing.json.key}")
	private String routingJsonKey;

	// spring bean for rabbit MQ Queue
	// use queue as return type from org.springframework.amqp.core.Queue; package
	@Bean
	public Queue queue() {
		// defining QueueName from application.properties file
		return new Queue(queueName);
	}

	// Queue to pass the message in JSON format
	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueue);
	}

	// create bean of exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	// create a binding with queue binding with exchange using routing key
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routing);
	}

	// Binding between JSON with exchange using routing key
	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(jsonQueue()).to(exchange()).with(routingJsonKey);
	}

	/*
	 * Apart from this we need to Configure below these three beans 1) connection
	 * factory 2) rabbit template 3) Rabbit Admin
	 * 
	 * but spring boot auto configure all these above three beans so we don't need
	 * to manually configure all the above three beans
	 */

	/* 
	 * Created a Message Converter bean to convert String to JSON
	 */
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	/*
	 * We are creating an object of rabbit template and setting the converter to that
	 * so that the rabbit template should convert the string to JSON using message Converter and return 
	 * need to lean more about this
	 */
	@Bean
	public AmqpTemplate amqpTemplete(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplete = new RabbitTemplate(connectionFactory);
		rabbitTemplete.setMessageConverter(converter());
		return rabbitTemplete;
	}

}
