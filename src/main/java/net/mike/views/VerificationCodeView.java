package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("verify")
public class VerificationCodeView extends Div {
  public VerificationCodeView() {
	  TextField vCode = new TextField("Insert verify code");
	  Button button = new Button("Verify");
	  add(vCode, button);
  }
}
