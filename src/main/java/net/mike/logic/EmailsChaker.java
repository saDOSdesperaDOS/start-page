package net.mike.logic;


import net.mike.dao.EmailsRegList;
import net.mike.dao.EmailsRegListImpl;


public class EmailsChaker {
	
	private static String email;
	private boolean isContains;
    
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		EmailsChaker.email = email;
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
		//
		//
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
}
