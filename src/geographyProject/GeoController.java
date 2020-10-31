package geographyProject;

import geographyProject.RegionHyrarchy.Country;

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
		});
		
		
		
	}

}
