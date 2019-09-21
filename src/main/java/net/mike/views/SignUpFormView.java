package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import net.mike.entities.Account;
import net.mike.services.AccountsService;

@Route("signup")
public class SignUpFormView extends VerticalLayout {
	
	public SignUpFormView() {
		
		FormLayout form = new FormLayout();
		TextField name = new TextField("Name");
		PasswordField pass = new PasswordField("Password");
		PasswordField confirmPass = new PasswordField("Confirm Password");
		/*create an instance that provides methods for servicing the Account entity*/
		AccountsService accountsService = new AccountsService();
		Button b = new Button("Register");
		
		  form.add(name, pass, confirmPass, b);
		  b.addClickListener( e-> {
			  		Account.getInstance().setPassword(pass.getValue());
			  		Account.getInstance().setName(name.getValue());
					accountsService.create(Account.getInstance());
					Notification.show("Your account created.");
					b.getUI().ifPresent(ui -> ui.navigate("login"));
			  });
		  
		  setWidth("25%");
		  setHeight("65%");
		  getElement().getStyle().set("position", "absolute");
		  getElement().getStyle().set("margin-top", "5%");
		  getElement().getStyle().set("margin-left", "37%");
		  add(form);
		
	}

}
