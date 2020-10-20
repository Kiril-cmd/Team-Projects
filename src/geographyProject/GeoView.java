package geographyProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
	// Left controls
	protected Button btnCountry = new Button("Country");
	protected Button btnState = new Button("State");
	protected Button btnCity = new Button("City");
	protected ListView<String> geoList = new ListView<String>();
	// Center controls
	protected TextField tfPopulation = new TextField();
	protected TextField tfFormOfGovernment = new TextField();
	protected TextField tfArea = new TextField();

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
		HBox leftControlBtns = new HBox();
		leftControlBtns.getChildren().addAll(btnCountry, btnState, btnCity);
		VBox leftControls = new VBox();
		leftControls.getChildren().addAll(leftControlBtns, geoList);
		ObservableList<String> items = FXCollections.observableArrayList("Switzerland", "Germany", "USA", "Canada");
		geoList.setItems(items);
				
		return leftControls;
	}
	
	public GridPane createCountryView() {
		GridPane countryRoot = new GridPane();
		
		Label lbInformation = new Label("Information");
		Label[] lbListCountries = new Label[6];
		String[] countryLabelText = {"Population", "Form-of-government", "Area", "States", "Cities", "History"};
		Label lbHistory = new Label("History");
		
		// This method creates static label objects for the country view and add those to the countryRoot
		for (int i = 0; i < lbListCountries.length; i++) {
			lbListCountries[i] = new Label(countryLabelText[i]);
			countryRoot.add(lbListCountries[i], 0, i++);
		}
		
		
		return countryRoot;
	}

}
