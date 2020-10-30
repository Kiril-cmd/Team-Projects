package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class Country extends GovernedRegion{
	String countryName;
	String currency;
	String phoneCode;
	
	ArrayList<State> states;
	ArrayList<City> cities;
	
	public Country(String newCountryName) {
		this.countryName = newCountryName;
		states = new ArrayList<State>();
		cities = new ArrayList<City>();
	}
	
	public void addState (State newState) {
		states.add(newState);
	}
	
	public void addCity (City newCity) {
		cities.add(newCity);
	}

}
