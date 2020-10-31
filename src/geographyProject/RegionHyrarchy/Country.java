package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class Country extends GovernedRegion{
	String countryName;
	String currency;
	String phoneCode;
	
	ArrayList<Country> countries;
	ArrayList<State> states;
		
	public Country(String newCountryName) {
		this.countryName = newCountryName;
		countries = new ArrayList<Country>();
		states = new ArrayList<State>();
		
	}
	
	public void addCountry (Country newCountry) {
		countries.add(newCountry);
	}
	
	public void addState (State newState) {
		states.add(newState);
	}
	
		
	public void removeCountry (Country newCountry) {
		countries.remove(newCountry);
	}
	
	public void removeState (State newState) {
		states.remove(newState);
	}
	
}
