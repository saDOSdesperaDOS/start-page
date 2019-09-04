package net.mike.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;

import net.mike.services.EmailsRegListService;
import net.mike.services.EmailsRegListServiceImpl;
import net.mike.logic.CodeGenerator;

@Route("check")
public class EmailCheckView extends Div {
	
	public EmailCheckView() {
	  
		EmailField email = new EmailField("Email");
		Button checkEmailButton = new Button("Check");
		String a = "a"; 
		
		add(email, checkEmailButton);
	//ТАК ОБРАБОТЧИК СОБЫТИЯ РАБОТАЕТ С ПЕРВОГО РАЗА	 
		   checkEmailButton.addClickListener( e-> {
			   									if(check(email.getValue())) checkEmailButton.getUI().ifPresent(ui -> ui.navigate("confirm"));
	      	    							  });
		     			setWidth("25%");
		     			setHeight("65%");
		     			getElement().getStyle().set("position", "absolute");
		     			getElement().getStyle().set("margin-top", "5%");
		     			getElement().getStyle().set("margin-left", "37%");
   }
	
	//Проверяем email на regex и на busy 
		public boolean check(String email) {
			EmailsRegListService eList = new EmailsRegListServiceImpl();
	     		if(regExpValidator(email)&&!eList.getAll(). contains(email)) {
	     			send(email);
	              //Notification.show("Verification code sent to your email");
	              return true;
	     		} else 
	            	Notification.show("Email busy or There was a mistake while entering Email");
	     return false;
	     }
		
		public boolean regExpValidator(String email) {
			Pattern p = Pattern.compile("^(.+)@(.+)$");
			Matcher m = p.matcher(email);
			return m.matches();
			}
		
		public void send(String email) {
			CodeGenerator cD = new CodeGenerator();
		    System.out.println("Подтвердите проверочный код:  - " + cD.getVerifyCode());
			
		}
		
}
