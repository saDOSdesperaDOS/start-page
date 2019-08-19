 package net.mike;

import net.mike.logic.EmailsCheker;

public class Test {
  public static void main(String[] fuck) {
	EmailsCheker emailsChecker = new EmailsCheker();
	System.out.println(emailsChecker.isContains());
	emailsChecker.check("emawdqwqil1@google.com");
	System.out.println(emailsChecker.isContains());
  }
}
