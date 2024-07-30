package com.as.mq.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.as.mq.constants.Constants;

@Component
public class MessageListener {

	@RabbitListener(queues = Constants.QUEUE)
	public void listener(CustomMessage message) {
		System.out.println(message);
	}
}
