package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import net.mike.logic.EmailsCheker;

@Route("check")
public class EmailCheckView extends Div {
  public EmailCheckView() {
	  EmailField email = new EmailField("Email");
	  EmailsCheker checker = new EmailsCheker();
	  Button sendEmail = new Button("Send", click -> checker.check(email.getValue()));
	  //sendEmail.addClickListener( e-> { 
   	   //sendEmail.getUI().ifPresent(ui -> ui.navigate("signup")); 
      //});
	  
	  add(email, sendEmail);
  }
}
