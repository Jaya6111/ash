package com.as.email.kafka;

import com.as.email.entity.EmailJSON;
import com.as.email.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {

    @Autowired
    private EmailService emailService;
	/*
	 * String toEmail; String username; String type; int userId; String subject;
	 * String body; String[] emailContents;
	 */

    @KafkaListener(topics = "email", groupId = "user-group")
    public void emailListner(String content) throws EmailException {

		/*
		 * emailContents = content.split("#");
		 * 
		 * toEmail = emailContents[0]; username = emailContents[1]; type =
		 * emailContents[2]; userId = Integer.parseInt(emailContents[3]);
		 */
    	ObjectMapper objectMapper = new ObjectMapper();
    	EmailJSON details = new EmailJSON();
		try {
			details = objectMapper.readValue(content, EmailJSON.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if(details.getType().equalsIgnoreCase("welcome")) {
            emailService.sendWelcomeMail(details.getEmail(), details.getUsername());
        }else if(details.getType().equalsIgnoreCase("verification")) {
            emailService.sendVerificationMail(details.getEmail(), details.getUsername(), details.getUserId());
        }else {
            emailService.sendGeneralMail(details.getEmail(), details.getUsername(), details.getSubject(), details.getBody());
        }
    }
}
