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


public class EmailsCheker {
	
	//private  String email;
	private boolean isContains;
	
	
    
	//public  String getEmail() {
		//return email;
	//}

	//public void setEmail(String email) {
	//	this.email = email;
	//}
	public EmailsCheker() {
		super();
	}

	public boolean isContains() {
		return isContains;
	}

	public void setContains(boolean yes) {
		yes = true;
		isContains = yes;
	}

	public boolean check(String email) {
		//-if true сравниваем его с каждым email'om из таблицы Emails 
		//если содержит то лови Exception, а если нет такого email'a то отправляем на него проверочный код
		EmailsRegList massiv = new EmailsRegListImpl();

     		if(!massiv.getAll(). contains(email)) {
              System.out.println("Чтобы закончить регистрацию, подтвердите число, которое было отправленно на указанный вами Email. ");
              isContains = true;
            } else {
            	System.out.println(email + " is busy");    
            	isContains = false;
              }
    return isContains;
    }
	
	
	//Отправляем код проверки на указаную почту 

	public void sendVeriCodeTo(String email) {
		
   	  EmailsCheker checker = new EmailsCheker();
   	  checker.check(email);
		
	  while(!checker.isContains) {
			System.out.println("отправляем проверочный код на указанную почту");
	  }
	}
}
