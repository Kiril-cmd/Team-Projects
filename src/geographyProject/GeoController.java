package geographyProject;

public class GeoController {
	private GeoModel model;
	private GeoView view;

	public GeoController(GeoModel model, GeoView view) {
		this.model = model;
		this.view = view;
		
		//Button events
		view.btnCreate.setOnAction(e -> {
			Country newCountry = new Country ("USA");
			
		});
		
		
	}

}
