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
				
		// This loop creates label objects for the country view and add those to the countryRoot
		for (int i = 0; i < lbListCountries.length; i++) {
			lbListCountries[i] = new Label(countryLabelText[i]);
			countryRoot.add(lbListCountries[i], 0, i + 1);
		}
		
		
					
		// Add remain objects to createCountryView
		countryRoot.add(lbInformationCountry, 0, 0);
		countryRoot.add(tfPopulationCountry, 1, 1);
		countryRoot.add(tfAreaCountry, 1, 2);
		countryRoot.add(tfFormOfGovernment, 1, 3);
		countryRoot.add(tfLanguagesCountry, 1, 4);
		countryRoot.add(tfCurrency, 1, 5);
		countryRoot.add(tfPhoneCode, 1, 6);
		countryRoot.add(stateListCountry, 1, 7);
		countryRoot.add(tfCapitalCityCountry, 1, 8);
		countryRoot.add(cityListCountry, 1, 9);
		countryRoot.add(taHistoryCountry, 0, 11, 2, 11);
		countryRoot.getStyleClass().add("country-root");
				
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
