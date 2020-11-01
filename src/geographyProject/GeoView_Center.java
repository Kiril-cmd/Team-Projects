package geographyProject;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GeoView_Center {
	// Panes for countryView, stateView and cityView
	GridPane countryView;
	GridPane stateView;
	GridPane cityView;
	
	
	// Country controls
	protected TextField tfPopulationCountry = new TextField();
	protected TextField tfAreaCountry = new TextField();
	protected TextField tfFormOfGovernment = new TextField();
	protected TextField tfLanguagesCountry = new TextField();
	protected TextField tfCurrency = new TextField();
	protected TextField tfPhoneCode = new TextField();
	protected ListView<String> stateListCountry = new ListView<String>();
	protected TextField tfCapitalCityCountry = new TextField();
	protected ListView<String> cityListCountry = new ListView<String>();
	protected TextArea taHistoryCountry = new TextArea();
	protected Control[] controlsCountry = {tfPopulationCountry, tfAreaCountry, tfFormOfGovernment, tfLanguagesCountry, tfCurrency, tfPhoneCode, 
			stateListCountry, tfCapitalCityCountry, cityListCountry, taHistoryCountry};
	
	// State controls
	protected TextField tfPopulationState = new TextField();
	protected TextField tfAreaState = new TextField();
	protected TextField tfMaxElevationState = new TextField();
	protected TextField tfMinElevationState = new TextField();
	protected TextField tfAvgElevationState = new TextField();
	protected TextField tfLanguageState = new TextField();
	protected TextField tfCapitalCityState = new TextField();
	protected ListView<String> cityListState = new ListView<String>();
	protected TextArea taHistoryState = new TextArea();
	protected Control[] controlsState = {tfPopulationState, tfAreaState, tfMaxElevationState, tfMinElevationState, tfAvgElevationState, tfLanguageState, 
			tfCapitalCityState, cityListState, taHistoryState};
	
	// City controls
	protected TextField tfPopulationCity = new TextField();
	protected TextField tfAreaCity = new TextField();
	protected TextField tfMaxElevationCity = new TextField();
	protected TextField tfMinElevationCity = new TextField();
	protected TextField tfAvgElevationCity = new TextField();
	protected TextField tfLanguageCity = new TextField();
	protected TextField tfZipCode = new TextField();
	protected TextField tfMayor = new TextField();
	protected TextArea taHistoryCity = new TextArea();
	Control[] controlsCity = {tfPopulationCity, tfAreaCity, tfMaxElevationCity, tfMinElevationCity, tfAvgElevationCity, tfLanguageCity, 
			tfZipCode, tfMayor, taHistoryCity};
	
	public GeoView_Center() {
		this.countryView = createCountryView();
		this.stateView = createStateView();
		this.cityView = createCityView();
	}
	
	// This method creates the countryView for user input
	public GridPane createCountryView() {
		GridPane countryRoot = new GridPane();
		
		String[] lbTextCountry = {"Population", "Area", "Form-of-government", "Languages", "Currency", "Phone code", 
				"States", "Capital city", "Cities", "History"};
		
		addStaticElements(countryRoot, lbTextCountry);
		addControls(countryRoot, controlsCountry);
		
		setStylesheets(countryRoot);
		
		return countryRoot;
	}
	
	// This method creates the stateView for user input
	public GridPane createStateView() {
		GridPane stateRoot = new GridPane();
		
		String[] lbTextState = {"Population", "Area", "Highest elevation", "Lowest Elevation", "Average Elevation", "Language", 
				"Capital city", "Cities", "History"};
		
		addStaticElements(stateRoot, lbTextState);
		addControls(stateRoot, controlsState);
		
		setStylesheets(stateRoot);
		
		return stateRoot;		
	}
	
	// This method creates the cityView for user input
	public GridPane createCityView() {
		GridPane cityRoot = new GridPane();
		
		String[] lbTextCity = {"Population", "Area", "Highest elevation", "Lowest elevation", "Average elevation",
				"Language", "Zip code", "Mayor", "History"};
		
		addStaticElements(cityRoot, lbTextCity);
		addControls(cityRoot, controlsCity);
		
		setStylesheets(cityRoot);
				
		return cityRoot;
	}
	
	private void addStaticElements(GridPane pane, String[] lbTextCountry) {
		Label[] lbListCountries = new Label[lbTextCountry.length];
		int columnIndex = 0;
		Label lbInformation = new Label("Information");
		
		pane.add(lbInformation, columnIndex, 0);
		
		for (int i = 0; i < lbListCountries.length; i++) {
			lbListCountries[i] = new Label(lbTextCountry[i]);
			pane.add(lbListCountries[i], columnIndex, i + 1);
		}
	}
	
	private void addControls(GridPane pane, Control[] controls) {
		int columnIndex = 1;
		
		for (int i = 0; i < controls.length; i++) {
			if (i < controls.length - 1) {
				pane.add(controls[i], columnIndex, i + 1);
			}else {
				pane.add(controls[i], 0, i + 2, 2, i + 2);
			}
			controls[i].setDisable(true);
		}
	}
	
	private void setStylesheets (GridPane pane) {
		pane.getStyleClass().add("main-root");
	}
	
	//getters for countryView, stateView and cityView
	public GridPane getCountryView() {
		return countryView;
	}
	
	public GridPane getStateView() {
		return stateView;
	}
	
	public GridPane getCityView() {
		return cityView;
	}
	
}
