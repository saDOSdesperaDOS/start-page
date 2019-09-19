 package net.mike;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import net.mike.entities.Account;
import net.mike.services.AccountsService;
import net.mike.services.CodeGenerator;
import net.mike.views.EmailCheckView;


public class Test {
  public static void main(String[] fuck) throws AddressException, MessagingException {
	/*EmailCheckView e = new EmailCheckView();
    e.check("mlerf3ers39rus@gmail.com");*/
	//AccountsService sqlRequest = new AccountsService();
	/* Account account = new Account("mls39rus@gmail.com", "utrdf6r", "Kirill");
	 System.out.println(sqlRequest.create(account));*/
	 // sqlRequest.remove(2);
	  //System.out.println(sqlRequest.getAllEmail());
    System.out.println(CodeGenerator.getInstance().getCode());
    System.out.println(CodeGenerator.getInstance().getCode().equals("PvEov3RErPotQrjt"));
    
    
  }
}
