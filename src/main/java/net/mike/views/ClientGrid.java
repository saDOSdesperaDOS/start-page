package net.mike.views;

import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import net.mike.entities.AutoPart;
import net.mike.services.AutoPartServices;

@Route("grid")
public class ClientGrid extends VerticalLayout {
	
	public ClientGrid() {
		   AutoPartServices request = new AutoPartServices();
	       List<AutoPart> priceList = request.getAllAutoParts();
	        Grid<AutoPart> wrapper = new Grid<>(AutoPart.class);
	        	wrapper.setItems(priceList);
	        	setSizeFull();
	        	add(wrapper);
	}

}
