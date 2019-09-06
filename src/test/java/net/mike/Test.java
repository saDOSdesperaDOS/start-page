 package net.mike;

import net.mike.entities.Account;
import net.mike.services.AccountsService;
import net.mike.services.EmailsRegListService;
import net.mike.services.EmailsRegListServiceImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;

public class Test {
  public static void main(String[] fuck) {
      EmailField email = new EmailField("sdfs@gmail.com");
      PasswordField password = new PasswordField("qwscw2eWqwe");
      String name = "Vasia";
      Account account = new Account(email, password, name);
      AccountsService sqlRequest = new AccountsService();
      sqlRequest.create(account);
  }
}
