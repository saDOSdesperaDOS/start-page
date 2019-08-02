package net.mike;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "webapp-vaadin-spring", shortName = "webapp-vaadin-spring")
public class MainView extends HorizontalLayout {

    public MainView() {
        Button b1 = new Button("Sign in");
        Button b2 = new Button("Sign up");
        	   add(b1);
               add(b2);
               getElement().getStyle().set("position", "absolute");
               getElement().getStyle().set("margin-top", "1%");
               getElement().getStyle().set("margin-left", "84%");
               b1.addClickListener( e-> { 
            	   b1.getUI().ifPresent(ui -> ui.navigate("signin")); 
               });
               b2.addClickListener( e-> { 
            	   b2.getUI().ifPresent(ui -> ui.navigate("signup")); 
               });
    }
}

