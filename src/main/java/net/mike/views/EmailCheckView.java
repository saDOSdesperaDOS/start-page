package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.EmailField;

import net.mike.logic.EmailsChaker;

public class EmailCheckView extends Div {
  public EmailCheckView() {
	  EmailField email = new EmailField("Verify your Email");
	  //Button sendEmail = new Button("Send", click -> EmailsChaker.check(email));
  }
}
