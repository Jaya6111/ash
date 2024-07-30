package com.as.email.util;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {
	
	public void sendEmail(String toEmail, String subject, String mailBody) throws EmailException {
		HtmlEmail htmlEMail = new HtmlEmail();
		htmlEMail.setSubject(subject);
		
		//Configuration
		htmlEMail.setHostName("smtp.gmail.com");
		htmlEMail.setSmtpPort(587);
		htmlEMail.setStartTLSEnabled(true);
		htmlEMail.setSSLOnConnect(true);
		htmlEMail.setAuthentication("matt.jonathan95@gmail.com", "ilpqxggfvrypjxko");

		InternetAddress internetAddress = new InternetAddress();
		internetAddress.setAddress(toEmail);

		List<InternetAddress> list = new ArrayList<InternetAddress>();
		list.add(internetAddress);

		htmlEMail.setFrom("matt.jonathan95@gmail.com", "Demo Application");
		htmlEMail.setTo(list);
		htmlEMail.setHtmlMsg(mailBody);

		htmlEMail.send();
	}
}
