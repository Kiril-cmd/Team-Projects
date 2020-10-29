package geographyProject;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class GeoView_Center {
	// Panes for the three views
	GridPane countryView;
	GridPane stateView;
	GridPane cityView;
	// Country controls
	protected TextField tfPopulation = new TextField();
	protected TextField tfArea = new TextField();
	protected TextField tfFormOfGovernment = new TextField();
	protected TextField tfLanguages = new TextField();
	protected TextField tfCurrency = new TextField();
	protected TextField tfPhoneCode = new TextField();
	protected ListView<String> stateList = new ListView<String>();
	protected TextField tfCapitalCity = new TextField();
	protected ListView<String> cityList = new ListView<String>();
	protected TextArea taHistory = new TextArea();
	
	public GeoView_Center() {
		this.countryView = createCountryView();
		this.stateView = createStateView();
		this.cityView = createCityView();
	}
	
	// This method creates the countryView for user input
	public GridPane createCountryView() {
		GridPane countryRoot = new GridPane();
		
		Label lbInformationCountry = new Label("Information");
		Label[] lbListCountries = new Label[10];
		String[] countryLabelText = {"Population", "Area", "Form-of-government", "Languages", "Currency", "Phone code", 
				"States", "Capital city", "Cities", "History"};
		Region[] spacer = new Region[lbListCountries.length];
		
		// This loop creates label objects for the country view and add those to the countryRoot
		for (int i = 0; i < lbListCountries.length; i++) {
			lbListCountries[i] = new Label(countryLabelText[i]);
			countryRoot.add(lbListCountries[i], 0, i + 1);
		}
		
		// Setting margins and gaps between cells 		
		countryRoot.setHgap(20);
		countryRoot.setVgap(20);
		countryRoot.setPadding(new Insets(30, 10, 10, 30));
					
		// Add remain objects to createCountryView
		countryRoot.add(lbInformationCountry, 0, 0);
		countryRoot.add(tfPopulation, 1, 1);
		countryRoot.add(tfArea, 1, 2);
		countryRoot.add(tfFormOfGovernment, 1, 3);
		countryRoot.add(tfLanguages, 1, 4);
		countryRoot.add(tfCurrency, 1, 5);
		countryRoot.add(tfPhoneCode, 1, 6);
		countryRoot.add(stateList, 1, 7);
		countryRoot.add(tfCapitalCity, 1, 8);
		countryRoot.add(cityList, 1, 9);
		countryRoot.add(taHistory, 0, 11, 2, 11);
				
		return countryRoot;
	}
	
	// This method creates the stateView for user input
	public GridPane createStateView() {
		GridPane stateRoot = new GridPane();

		
		return stateRoot;
	}
	
	// This method creates the cityView for user input
	public GridPane createCityView() {
		GridPane cityRoot = new GridPane();
		
		Label lbInformationCity = new Label("Information");
		Label[] lbListCities = new Label[9];
		String[] cityLabelText = {"Population", "Area", "Highest elevation", "Lowest elevation", "Elevation",
				"Language", "Zip code", "Mayor", "History"};
		
		for (int i = 0; i < lbListCities.length; i++) {
			lbListCities[i] = new Label(cityLabelText[i]);
			cityRoot.add(lbListCities[i], 0, i + 1);
		}
		
		return cityRoot;
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
