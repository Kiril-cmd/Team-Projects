package geographyProject;

import geographyProject.RegionHyrarchy.Country;
import javafx.scene.control.TextField;

public class GeoController {
	private GeoModel model;
	private GeoView view;

	public GeoController(GeoModel model, GeoView view) {
		this.model = model;
		this.view = view;
		
		
		leftControlsEvents();
	}
	
	private void leftControlsEvents () {
		
		//Button events
		view.btnCreate.setOnAction(e -> {
			//String country = view.itemList.getItems().add(e);
		
			String newCountry = view.tfEnterZone.getText();
			if (newCountry.length() > 0 && !newCountry.contains(" ")) {
				model.addCountry(newCountry); 
				updateView(newCountry);
			} else {
				
			}
		});
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
