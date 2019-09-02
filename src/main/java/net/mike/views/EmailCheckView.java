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
		Button checkEmailButton = new Button("Check");
		String a = "a"; 
		
		add(email, checkEmailButton);
	//ТАК ОБРАБОТЧИК СОБЫТИЯ РАБОТАЕТ С ПЕРВОГО РАЗА	 
		   checkEmailButton.addClickListener( e-> {
			   									if(true) checkEmailButton.getUI().ifPresent(ui -> ui.navigate("confirm"));
	      	    							  });
		 
		     			setWidth("25%");
		     			setHeight("65%");
		     			getElement().getStyle().set("position", "absolute");
		     			getElement().getStyle().set("margin-top", "5%");
		     			getElement().getStyle().set("margin-left", "37%");
		     			
   }
	
	
}
