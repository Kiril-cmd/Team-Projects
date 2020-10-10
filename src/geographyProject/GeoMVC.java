package geographyProject;

import javafx.application.Application;
import javafx.stage.Stage;

public class GeoMVC extends Application {
	private GeoModel model;
	private GeoView view;
	private GeoController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.model = new GeoModel();
		this.view = new GeoView(primaryStage, model);
		this.controller = new GeoController(model, view);
		view.start();

	}

	public static void main(String[] args) {
		launch();
	}

}
