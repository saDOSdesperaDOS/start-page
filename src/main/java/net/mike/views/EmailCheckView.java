package net.mike.views;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*; 

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;

import net.mike.entities.Account;
import net.mike.services.CodeGenerator;
import net.mike.services.EmailsRegListService;
import net.mike.services.EmailsRegListServiceImpl;

@Route("check")
public class EmailCheckView extends Div {
	
	public EmailCheckView() {
	  
		EmailField email = new EmailField("Email");
		Button checkEmailButton = new Button("Check");
		String a = "a"; 
		
		add(email, checkEmailButton);
	//ТАК ОБРАБОТЧИК СОБЫТИЯ РАБОТАЕТ С ПЕРВОГО РАЗА	 
		   checkEmailButton.addClickListener( e-> {
			   										if(check(email.getValue())) {
			   											try {
															send(email.getValue());
														} catch (AddressException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														} catch (MessagingException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
			   											Account.getInstance().setEmail(email.getValue());
			   											checkEmailButton.getUI().ifPresent(ui -> ui.navigate("confirm"));
			   										}
	      	    							  	  }
		                                      );
		     			setWidth("25%");
		     			setHeight("65%");
		     			getElement().getStyle().set("position", "absolute");
		     			getElement().getStyle().set("margin-top", "5%");
		     			getElement().getStyle().set("margin-left", "37%");
   }
	
	//Проверяем email на regex и на busy 
		public boolean check(String email) {
			EmailsRegListService eList = new EmailsRegListServiceImpl();
	     		if(regExpValidator(email)&&!eList.getAll(). contains(email)) {
	     			//send(email);
	              //Notification.show("Verification code sent to your email");
	              return true;
	     		} else 
	            	Notification.show("Email busy or There was a mistake while entering Email");
	     return false;
	     }
		
		public boolean regExpValidator(String email) {
			Pattern p = Pattern.compile("^(.+)@(.+)$");
			Matcher m = p.matcher(email);
			return m.matches();
			}
		
		public void send(String email) throws AddressException, MessagingException {
			CodeGenerator cD = new CodeGenerator();
		    //System.out.println("Подтвердите проверочный код:  - " + cD.getVerifyCode());
			  String password = "<vc39hec";
		      String to = email;
		      final String from = "bms39rus@gmail.com";

		      Properties properties = new Properties();
		      properties.put("mail.smtp.starttls.enable", "true");
		      properties.put("mail.smtp.auth", "true");
		      properties.put("mail.smtp.host", "smtp.gmail.com");
		      properties.put("mail.smtp.port", "587");

		      Session session = Session.getInstance(properties,
		              new javax.mail.Authenticator() {
		                  protected PasswordAuthentication getPasswordAuthentication() {
		                      return new PasswordAuthentication(from, password);
		                  }
		              });

		      MimeMessage message = new MimeMessage(session);
		      message.setFrom(new InternetAddress(from));
		      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		      message.setSubject("Veryfing your email");
		      message.setText(cD.getVerifyCode());

		      Transport.send(message);
		}
}
