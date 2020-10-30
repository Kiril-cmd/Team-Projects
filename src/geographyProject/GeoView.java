package geographyProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GeoView {
	private Stage stage;
	private GeoModel model;
	
	ScrollPane centerView = new ScrollPane();
	
	// Top controls
	protected Button btnCreate = new Button ("Create");
	protected Button btnEdit = new Button ("Edit");
	protected Button btnDelete = new Button ("Delete");
	protected Button btnSave = new Button ("Save");
	// Left controls
	protected Button btnCountry = new Button("Country");
	protected Button btnState = new Button("State");
	protected Button btnCity = new Button("City");
	protected ListView<String> countryList = new ListView<String>();
	
	public GeoView(Stage primaryStage, GeoModel model) {
		this.stage = primaryStage;
		this.model = model;
		
		stage.setTitle("Geo Database");
		
		centerView.setHbarPolicy(ScrollBarPolicy.NEVER);
		centerView.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		centerView.setFitToWidth(true);

		
		// Create Masterpane for the different UI areas
		BorderPane root = new BorderPane();
		GeoView_Center centerRoot = new GeoView_Center();
		centerView.setContent(centerRoot.getCountryView());
		root.setTop(createDataControls());
		root.setLeft(createLeftControls());
		root.setCenter(centerView);
		
		
		// TO DO: set up scene
		Scene scene = new Scene(root, 800, 1000);
		scene.getStylesheets().add(getClass().getResource("geographyProject.css").toExternalForm());
		stage.setScene(scene);

	}
	
	public void start() {
		stage.show();
	}
	
	public HBox createDataControls() {
		HBox topBtnPane = new HBox();
				
		topBtnPane.getChildren().addAll(btnCreate, btnEdit, btnDelete, btnSave);
		topBtnPane.getStyleClass().add("top-pane");
		
		return topBtnPane;
	}
	
	public VBox createLeftControls() {
		HBox leftControlBtns = new HBox();
		leftControlBtns.getChildren().addAll(btnCountry, btnState, btnCity);
		VBox leftControls = new VBox();
		leftControls.getChildren().addAll(leftControlBtns, countryList);
		ObservableList<String> items = FXCollections.observableArrayList("Switzerland", "Germany", "USA", "Canada");
		countryList.setItems(items);
		leftControlBtns.getStyleClass().add("left-control-btns");

				
		return leftControls;
	}

}
