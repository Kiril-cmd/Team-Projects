package geographyProject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GeoView {
	private Stage stage;
	private GeoModel model;
	
	// Top controls
	protected Button btnCreate = new Button ("Create");
	protected Button btnEdit = new Button ("Edit");
	protected Button btnDelete = new Button ("Delete");
	protected Button btnSave = new Button ("Save");

	public GeoView(Stage primaryStage, GeoModel model) {
		this.stage = primaryStage;
		this.model = model;
		
		stage.setTitle("Geo Database");
		
		// Create Masterpane for the different UI areas
		BorderPane root = new BorderPane();
		root.setTop(createDataControls());
		root.setLeft(createLeftControls());
		
		// TO DO: set up scene
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("geographyProject.css").toExternalForm());
		stage.setScene(scene);

	}
	
	public void start() {
		stage.show();
	}
	
	public HBox createDataControls() {
		HBox topBtnPane = new HBox();
		Region spacer = new Region();
		Region spacer1 = new Region();
		Region spacer2 = new Region();
		
		spacer.setPrefWidth(10);
		spacer1.setPrefWidth(10);
		spacer2.setPrefWidth(10);
		
		topBtnPane.getChildren().addAll(btnCreate, spacer, btnEdit, spacer1, btnDelete, spacer2, btnSave);
		
		return topBtnPane;
	}
	
	public VBox createLeftControls() {
		VBox leftControls = new VBox();
		
		return leftControls;
	}

}
