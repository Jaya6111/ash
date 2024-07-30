package com.as.spring.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.as.spring.entity.PracticeUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaListner {

	public static final String DELETE_USER = "noUser";

	public static final String SINGLE_USER = "oneUser";

	public static final String ALL_USERS = "multipleUsers";

	private final CountDownLatch latch = new CountDownLatch(1);

	List<PracticeUser> users = new ArrayList<PracticeUser>();
	PracticeUser user = new PracticeUser();
	String deleted = null;
	private ObjectMapper objectMapper = new ObjectMapper();
	//private Object object = new Object();

	@KafkaListener(topics = { ALL_USERS, SINGLE_USER, DELETE_USER }, groupId = ("security-group"))
	public void listner(String message) throws JsonMappingException, JsonProcessingException {

		//System.out.println("Received message: " + message);

		try {
			String[] arr = message.split("-");
			if (arr.length < 2) {
				throw new ArrayIndexOutOfBoundsException("Message does not contain expected parts: " + message);
			}
			// String[] arr = message.split(",");
			// object = arr[0];
			String s = arr[0];
			String value = arr[1];

			switch (value) {

			case ALL_USERS: {
				users = (List<PracticeUser>) objectMapper.readValue(s, users.getClass());

				break;
			}
			case SINGLE_USER: {
				user = objectMapper.readValue(s, PracticeUser.class);
				break;
			}
			case DELETE_USER: {
				deleted = objectMapper.readValue(s, String.class);
				break;
			}
			}
			latch.countDown();
		} catch (ArrayIndexOutOfBoundsException | JsonProcessingException e) {
			System.err.println("Exception in listener: " + e.getMessage());
			throw e; 
		}

	}

	public List<PracticeUser> allUsers() throws InterruptedException {
		
		  latch.await(); return users;
		 
		/*
		 * boolean done = latch.await(5, TimeUnit.SECONDS); // Waits up to 30 seconds if
		 * (!done) { throw new RuntimeException("Timeout waiting for Kafka message"); }
		 * return users;
		 */
	}

	public PracticeUser singleUser() throws InterruptedException {
		
		latch.await();
		return user;
	}

	public String deletedUser() throws InterruptedException {
		
		latch.await();
		return deleted;
	}

}
