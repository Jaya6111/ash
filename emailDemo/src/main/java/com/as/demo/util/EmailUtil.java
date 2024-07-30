package com.as.demo.util;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private SendEmail sendEmail;

	public void sendWelcomeMail(String toEmail, String name) throws EmailException {

		String subject = "welcome to Demo Application";
		StringBuilder mailBody = new StringBuilder();
		mailBody.append("<html>");
		mailBody.append("<body>");
		mailBody.append("<div>");

		mailBody.append("<p>Welcome&nbsp;" + name + ",</p><br><br>");
		/*
		 * mailBody.append(
		 * "Dear Candidate, <br><br>Your resume is shortlisted for F2F Interview rounds, Pls find below venue details, <br><br>Venue - <br>IDBI Intech Ltd, <br>IDBI Bank Building,<br>2nd Floor, IT Dept,<br>Plot No.39 - 41, Sector -11, <br>CBD Belapur, <br>Navi Mumbai - 400 614. <br><br><mark>Time - 11.00am - 05.00pm <br>Date - 17th Jan & 18th Jan 2024</mark>. <br><br>Regards, <br>Viraj S"
		 * );
		 */
		mailBody.append("<p>Thank you for registring with <b>Demo Application<b>.");
		mailBody.append("</div>");
		mailBody.append("</body>");
		mailBody.append("</html>");

		/*
		 * SimpleMailMessage message = new SimpleMailMessage();
		 * 
		 * message.setFrom("mahalakshmimatta6@gmail.com"); message.setTo(toEmail);
		 * message.setSubject(subject); message.setText(mailBody.toString());
		 * 
		 * mailSender.send(message);
		 */
		sendEmail.sendEmail(toEmail, subject, mailBody.toString());
	}

	public void sendVerificationMail(String toEmail,String name, int userId) throws EmailException {
		
		String subject = "Email Verification - Demo Application";
		StringBuilder mailBody = new StringBuilder();
		mailBody.append("<html>");
		mailBody.append("<body>");
		mailBody.append("<div>");

		mailBody.append("<p>Dear " + name + ",</p><br><br>");
		mailBody.append("<p>Thank you for registering with <b>Demo Application<b>.</p><br><br>");
		mailBody.append("<p>Please click the link below to verify your email:</p><br>");
		mailBody.append("<a href=\"http://localhost:8089/demo/verify/" + userId + "\">Verify Email</a>");

		mailBody.append("</div>");
		mailBody.append("</body>");
		mailBody.append("</html>");
		
		sendEmail.sendEmail(toEmail, subject, mailBody.toString());

	}
}
