package geographyProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GeoView {
	private Stage stage;
	private GeoModel model;
	
	private ScrollPane centerView = new ScrollPane();
	
	// creates center of UI
	protected GeoView_Center centerRoot = new GeoView_Center();
	
	// Top controls
	protected Button btnCreate = new Button ("Create");
	protected ToggleButton btnEdit = new ToggleButton ("Edit");
	protected Button btnDelete = new Button ("Delete");
	protected Button btnSave = new Button ("Save");
	protected TextField tfEnterZone = new TextField ();
	// Left controls
	protected TabPane tabPane = new TabPane();
	protected Tab tabCountry = new Tab("Country");
	protected Tab tabState = new Tab("State");
	protected Tab tabCity = new Tab("City");
	protected ObservableList<String> items = FXCollections.observableArrayList();
	protected ListView<String> itemList = new ListView<String>();
	
	// Alerts
	protected Alert alertEntry = new Alert(AlertType.ERROR);
	protected Alert alertEntryCenter = new Alert(AlertType.ERROR);
	protected Alert alertDoubleEntry = new Alert(AlertType.ERROR);
	protected String doubleCountry = "Country with the entered name already exists";
	protected String doubleState = "State with the entered name already exists";
	protected String doubleCity = "City with the entered name already exists";
		
	public GeoView(Stage primaryStage, GeoModel model) {
		this.stage = primaryStage;
		this.model = model;
		
		stage.setTitle("Geo Database");
		
		centerView.setHbarPolicy(ScrollBarPolicy.NEVER);
		centerView.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		centerView.setFitToWidth(true);
		
		
		// Create Masterpane for the different UI areas
		BorderPane root = new BorderPane();
		centerView.setContent(centerRoot.getCountryView());
		root.setTop(createDataControls());
		root.setLeft(createLeftControls());
		root.setCenter(centerView);
		
		
		// Alert when invalid itemName
		alertEntry.setTitle("Error Dialog");
		alertEntry.setHeaderText("Invalid Data");
		alertEntry.setContentText("Your entry is empty or contains spaces");
		
		// Alert when invalid centerEntry
		alertEntryCenter.setTitle("Error Dialog");
		alertEntryCenter.setHeaderText("Invalid Data");
		alertEntryCenter.setContentText("Your entry contains invalid data");
		
		// Alert when double name
		alertDoubleEntry.setTitle("Error Dialog");
		alertDoubleEntry.setHeaderText("Invalid Data");
		
		// TO DO: set up scene
		Scene scene = new Scene(root, 800, 1000);
		scene.getStylesheets().add(getClass().getResource("geographyProject.css").toExternalForm());
		stage.setScene(scene);

	}
	
	public void showCenterView(Tab newValue) {
		if (newValue == tabCountry) {
			centerView.setContent(centerRoot.getCountryView());
		}
		if (newValue == tabState) {
			centerView.setContent(centerRoot.getStateView());
		}
		if (newValue == tabCity) {
			centerView.setContent(centerRoot.getCityView());
		}
	}

	public void start() {
		stage.show();
	}
	
	public HBox createDataControls() {
		HBox topBtnPane = new HBox();
		Region spacing = new Region();
				
		topBtnPane.getChildren().addAll(tfEnterZone, spacing, btnCreate, btnEdit, btnDelete, btnSave);
		tfEnterZone.setPromptText("Enter an area");
		tfEnterZone.setId("enter-zone-tf");
		topBtnPane.getStyleClass().add("top-pane");
		
		return topBtnPane;
	}
	
	public VBox createLeftControls() {
		HBox leftControlBtns = new HBox();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabPane.getTabs().add(tabCountry);
		tabPane.getTabs().add(tabState);
		tabPane.getTabs().add(tabCity);
		
		leftControlBtns.getChildren().addAll(tabPane);
		
		
		VBox leftControls = new VBox();
		leftControls.getChildren().addAll(leftControlBtns, itemList);
		
		itemList.setItems(items);
		
		leftControlBtns.getStyleClass().add("left-control-btns");

		return leftControls;
	}
}
