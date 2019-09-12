 package net.mike;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import net.mike.views.EmailCheckView;


public class Test {
  public static void main(String[] fuck) throws AddressException, MessagingException {
	EmailCheckView e = new EmailCheckView();
    e.send("mls39rus@gmail.com");
  }
}
