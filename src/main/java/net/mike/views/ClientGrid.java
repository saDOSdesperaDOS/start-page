package net.mike.views;

import java.util.List;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import net.mike.entities.AutoPart;
import net.mike.services.AutoPartServices;

@Route("grid")
public class ClientGrid extends VerticalLayout {
	
    private TextField leaderCodeFilter;
	private Grid<AutoPart> wrapper;
	private AutoPartServices request;
	private List<AutoPart> priceList;
		
		public ClientGrid() {
			request = new AutoPartServices();
		   	priceList = request.getAllAutoParts();
	       	wrapper = new Grid<>(AutoPart.class);
	    	leaderCodeFilter = new TextField();
	       	leaderCodeFilter.setPlaceholder("Enter part number");
	       	leaderCodeFilter.addValueChangeListener(this::onNameFilterTextChange);
	       	wrapper.setItems(priceList);
	       		setSizeFull();
	       		add(leaderCodeFilter, wrapper);
		}
	
		private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
			ListDataProvider<AutoPart> dataProvider = (ListDataProvider<AutoPart>) wrapper.getDataProvider();
			dataProvider.setFilter(AutoPart :: getLeaderCode, s -> caseInsensitiveContains(s, event.getValue()));
		}

    private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }

}
