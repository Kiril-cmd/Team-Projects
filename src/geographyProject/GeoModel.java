package geographyProject;

import java.util.ArrayList;

import geographyProject.RegionHyrarchy.City;
import geographyProject.RegionHyrarchy.Country;
import geographyProject.RegionHyrarchy.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GeoModel {
	
	public final ObservableList<Country> countries = FXCollections.observableArrayList();
	public final ObservableList<State> states = FXCollections.observableArrayList();
	public final ObservableList<City> cities = FXCollections.observableArrayList();

	
	public void addCountry (String newCountry) {
		countries.add(new Country(newCountry));
	}
	
	public void addState (String newState) {
		states.add(new State(newState));
	}
	
	public void addCity (String newCity) {
		cities.add(new City(newCity));
	}
	
	public void deleteCountry(String name) {
		boolean found = false;
		for (int i = 0; i < countries.size() && found == false; i++) {
			// will be implemented after implementing id
		}
	}
	
	public void editData() {
		
	}
	

	

	
	
}
