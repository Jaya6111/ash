package com.as.email.controller;

import javax.validation.Valid;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.as.email.request.VerificationRequest;
import com.as.email.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/welcome")
	public String welcomeEmail(@RequestParam @Valid String toEmail, @RequestParam String name) {
		String message = null;
		try {
			emailService.sendWelcomeMail(toEmail, name);
			message = "Mail sent successfully";
		} catch (EmailException e) {
			message = e.toString();
		}
		return message;
	}
	
	@RequestMapping(value = "/verify", method = RequestMethod.GET, produces = MediaType.APPLICATION_XHTML_XML_VALUE)
	public String verificationEmail(@RequestBody @Valid VerificationRequest request) {
		
		String message = null;
		try {
			emailService.sendVerificationMail(request.getToEmail(), request.getName(), request.getUserId());
			message = "Success";
		} catch (EmailException e) {
			message = "Failure";
		}
		return message;
	}

}
