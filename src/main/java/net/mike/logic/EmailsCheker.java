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
import com.vaadin.flow.data.validator.EmailValidator;


public class EmailsCheker {
	
	//private  String email;
	private boolean isContains, isVerify;
	private String code;
	//private EmailValidator eValidator = new EmailValidator("Dont RIGTH email!!!!");
    
	public boolean isVerify() {
		return isVerify;
	}

	public void setVerify(boolean isVerify) {
		this.isVerify = isVerify;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public EmailsCheker() {
		super();
	}

	public boolean isContains() {
		return isContains;
	}

	public void changeContains() {
		isContains = true;
	}

	public void check(String email) {
		//-if true сравниваем его с каждым email'om из таблицы Emails 
		//если содержит то лови Exception, а если нет такого email'a то отправляем на него проверочный код
		EmailsRegList eList = new EmailsRegListImpl();
     		if(regExpValidator(email)&&!eList.getAll(). contains(email)) {
              System.out.println("В списке зарегистрированых email'ов данный email отсутствует. Далее необходимо отправить на него проверочный код");
             
     		
     		} else {
            	isContains = true;
            	System.out.println(email + " is busy");
              }
    }
	
	public boolean regExpValidator(String email) {
		Pattern p = Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher(email);
		boolean validExp = m.matches();
		return validExp;
		}
	
	
	
	public void send(String email, String code) {
		
	}
	
	public boolean verify(String code) {
		String responseCode = null;
		this.send("email", code);
		
		if(code.equals(responseCode)) {
			isVerify = true;
		}
		return isVerify;
	}
}
