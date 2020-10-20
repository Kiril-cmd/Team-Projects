package geographyProject;

import java.util.ArrayList;

public class Country extends GovernedRegion{
	String countryName;
	
	ArrayList<State> states;
	
	public Country(String newCountryName) {
		this.countryName = newCountryName;
		states = new ArrayList<State>();
		
	}
	
	public void addState (State newState) {
		states.add(newState);
	}

}
