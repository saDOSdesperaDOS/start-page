package net.mike.logic;

import net.mike.dao.EmailsRegList;
import net.mike.dao.EmailsRegListImpl;
import java.util.Properties;
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
	private boolean isContains;
	private EmailValidator eValidator = new EmailValidator("Dont RIGTH email!!!!");
    
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
     		if(!eList.getAll(). contains(email)) {
              System.out.println("В списке зарегистрированых email'ов данный email отсутствует. Далее необходимо отправить на него проверочный код");
            } else {
            	isContains = true;
            	System.out.println(email + " is busy");
              }
    }
	
	public void send() {
		
	}
}
