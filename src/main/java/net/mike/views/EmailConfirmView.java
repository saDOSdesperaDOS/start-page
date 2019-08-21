package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.mike.logic.EmailsCheker;

@Route("confirm")
public class EmailConfirmView extends Div {
  
	public  EmailConfirmView() {
		
		
		//EmailsCheker checker = new EmailsCheker();
	    TextField verifyCode = new TextField("Insert verify code");
	    Button button = new Button("Verify"/*, click -> checker.verify(verifyCode.getValue())*/);
	    
	    if (/*checker.verify(verifyCode.getValue()) == */true) {
	    	button.addClickListener( e-> { 
			   	   button.getUI().ifPresent(ui 
			   			   -> ui.navigate("signup")); 
			  }); 
	    }
	    setWidth("25%");
		setHeight("65%");
		getElement().getStyle().set("position", "absolute");
		getElement().getStyle().set("margin-top", "5%");
		getElement().getStyle().set("margin-left", "37%");
	  
	    add(verifyCode, button);
  }
}
