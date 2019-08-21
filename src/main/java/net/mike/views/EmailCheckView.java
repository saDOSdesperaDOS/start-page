package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import net.mike.logic.EmailsCheker;

@Route("check")
public class EmailCheckView extends Div {
 
	public EmailCheckView() {
	  
	  EmailField email = new EmailField("Email");
	  EmailsCheker checker = new EmailsCheker();
	  Button checkEmail = new Button("Check", click -> (checker.check(email.getValue()) == false) ? checkEmail.addClickListener( e-> { checkEmail.getUI().ifPresent(ui 
	   			   -> ui.navigate("confirm")}) : Notification.show("Такой email уже существует или вы допустили ошибку при вводе")
			  );
	  
	  
	  setWidth("25%");
	  setHeight("65%");
	  getElement().getStyle().set("position", "absolute");
	  getElement().getStyle().set("margin-top", "5%");
	  getElement().getStyle().set("margin-left", "37%");
	  add(email, checkEmail);
  }
}
