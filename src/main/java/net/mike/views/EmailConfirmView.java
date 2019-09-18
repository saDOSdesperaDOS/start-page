package net.mike.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.mike.services.CodeGenerator;

@Route("confirm")
public class EmailConfirmView extends Div {
  
	public  EmailConfirmView() {
	    TextField clientCode = new TextField("Insert verify code");
	    Button button = new Button("Verify");
	    		    	//if (clientCode.getValue().equals(CodeGenerator.getInstance().toString())) 
	    	           
	    
	    setWidth("25%");
		setHeight("65%");
		getElement().getStyle().set("position", "absolute");
		getElement().getStyle().set("margin-top", "5%");
		getElement().getStyle().set("margin-left", "37%");
	  
	    add(clientCode, button);
	    
	    button.addClickListener(e -> {
	    	if (clientCode.getValue().equals(CodeGenerator.getInstance().toString())) {
	    		
	    	}
	    });
  }
}
