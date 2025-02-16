package com.RabbitMQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RabbitMQ.dto.User;
import com.RabbitMQ.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

	@Autowired
	private RabbitMQJsonProducer rabbitMQJsonProducer;

	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
		rabbitMQJsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("JSON message send to RabbitMQ");
	}

}
