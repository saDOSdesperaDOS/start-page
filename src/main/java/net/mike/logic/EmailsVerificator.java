package net.mike.logic;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailsVerificator {

	public void sendTo() {
		
		System.out.println(" На ваш email выслан проверочный код.");
		
		String to = "mls39rus@gmail.com";
		String from = "bms39rus@gmail.com";
		String host = "smtp.gmail.com";
		int port = 465;
		
		Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.port", port);
			props.put("mail.smptp.auth", "true");
			props.put("mail.debug", "true");
			
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("bms39rus@gmail.com", "QwerTyui9988");
			}
		});
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject("Test E-mail thtow Java");
			msg.setText("This is a test of sending a" + 
			"plain text e-mail through Java.\n" + 
					"Here is line 2.");
			
			Transport.send(msg);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
