package geographyProject;

import java.util.ArrayList;

import geographyProject.RegionHyrarchy.City;
import geographyProject.RegionHyrarchy.Country;
import geographyProject.RegionHyrarchy.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GeoModel {
	
	private final ObservableList<Country> countries = FXCollections.observableArrayList();
	private final ObservableList<State> states = FXCollections.observableArrayList();
	private final ObservableList<City> cities = FXCollections.observableArrayList();

	
	public void createData (String name) {
		countries.add(new Country("USA"));
		states.add(new State("California"));
		cities.add(new City("Los Angeles"));
	}
	
	public void deleteData ()
	{
		
	}
	

	
	
}
