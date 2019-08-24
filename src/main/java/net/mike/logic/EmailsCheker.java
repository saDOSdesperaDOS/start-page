package net.mike.logic;

import net.mike.dao.EmailsRegList;
import net.mike.dao.EmailsRegListImpl;
import net.mike.views.EmailCheckView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.validator.EmailValidator;


public class EmailsCheker {
	
	//private  String email;
	private boolean isContains, isVerify;
	//private String code;
	private String verifyCode, responseCode;
	//private EmailValidator eValidator = new EmailValidator("Dont RIGTH email!!!!");
    
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public void setContains(boolean isContains) {
		this.isContains = isContains;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public boolean isVerify() {
		return isVerify;
	}

	public void setVerify(boolean isVerify) {
		this.isVerify = isVerify;
	}

	public boolean isContains() {
		return isContains;
	}

	public void changeContains() {
		isContains = true;
	}
    
	//Проверяем email на regex и на busy 
	public boolean check(String email) {
		
		EmailsRegList eList = new EmailsRegListImpl();
     		if(regExpValidator(email)&&!eList.getAll(). contains(email)) {
              isContains = false;
     			send(email);
              Notification.show("Verification code sent to your email");
              new EmailCheckView().addClickListener( e-> { 
            	  new EmailCheckView().getUI().ifPresent(ui -> ui.navigate("signin")); 
              });
     		} else {
            	isContains = true;
            	Notification.show("Email busy or There was a mistake while entering Email");
              }
     return isContains;
     }
	
	public boolean regExpValidator(String email) {
		Pattern p = Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher(email);
		boolean validExp = m.matches();
		return validExp;
		}
	
	public void send(String email) {
		CodeGenerator cD = new CodeGenerator();
	    verifyCode = cD.getVerifyCode();
	    System.out.println("Подтвердите проверочный код:  - " + verifyCode);
		
	}
	
	public boolean verify(String responseCode) {
		if(verifyCode.equals(responseCode)) {
			isVerify = true;
		}
	return isVerify;
	}
}
