package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import net.mike.logic.EmailsCheker;

@Route("check")
public class EmailCheckView extends Div {
	EmailField email;
	EmailsCheker checker;
	Button checkEmailButton;
	public EmailCheckView() {
	  
		 email = new EmailField("Email");
		 checker = new EmailsCheker();
		 checkEmailButton = new Button("Check", click -> {
	  										            	checkView(email.getValue());
	  										            	});
	  setWidth("25%");
	  setHeight("65%");
	  getElement().getStyle().set("position", "absolute");
	  getElement().getStyle().set("margin-top", "5%");
	  getElement().getStyle().set("margin-left", "37%");
	  add(email, checkEmailButton);
  }
	
	public boolean checkView(String email) {
		boolean value = false;
		if(checker.check(email) == false) 
      		addClickListener( e-> {
      		getUI().ifPresent(ui -> ui.navigate("confirm"));
      		}
      		);
		return value;
	}
}
