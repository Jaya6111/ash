package com.as.mq.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.mq.constants.Constants;

@RestController
public class MessageController {
	@Autowired
	private RabbitTemplate template;

	@PostMapping("/publish")
	public String publishMessage(@RequestBody CustomMessage message) {
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		template.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, message);

		return "Message Published";
	}
}
