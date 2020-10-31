package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class State extends GovernedRegion{
	String stateName;
	
	
	ArrayList<City> cities;
	ArrayList<State> states;
	
	public State (String newStateName) {
		this.stateName = newStateName;
		cities = new ArrayList<City>();
	}
	
	public void addState (State newState) {
		states.add(newState);
	}
	
	public void addCity (City newCity) {
		cities.add(newCity);
	}
}
