package geographyProject;

import java.awt.event.ActionEvent;

import geographyProject.RegionHyrarchy.Country;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class GeoController {
	private GeoModel model;
	private GeoView view;
	private GeoView_Center centerView;

	public GeoController(GeoModel model, GeoView view) {
		this.model = model;
		this.view = view;
		
		
		leftControlsEvents();
		topControlsEvents();
	}
	
	private void topControlsEvents() {
		
		//Button events
		view.btnCreate.setOnAction(e -> {
			String newCountry = view.tfEnterZone.getText();
			
			if (newCountry.length() > 0 && !newCountry.contains(" ")) {
				model.addCountry(newCountry); 
				updateView(newCountry);
			} else {
				view.alertEntry.showAndWait();
			}
		});
		
		view.btnEdit.setOnMouseClicked(this::edit);
		
	}

	private void leftControlsEvents () {
	
	}
	
	private void edit(MouseEvent e) {
		if (view.itemList.getSelectionModel().getSelectedItem() != null)
		for (int i = 0; i < view.centerRoot.controlsCountry.length; i++) {
			view.centerRoot.controlsCountry[i].setDisable(false);
		}
	}
	
	private void updateView (String newCountry) {
		
			view.items.clear();
			
		for (int i = 0; i < model.countries.size(); i++) {
			Country country = model.countries.get(i);
			String countryText = country.getName();
			view.items.add(countryText);
		}
		
		
		
	}

}
