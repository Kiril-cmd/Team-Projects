package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class State extends GovernedRegion{
	String stateName;
	int highestElevation;
	int lowestElevation;
	int averageElevation;
	
	ArrayList<City> cities;
	
	public State (String newStateName) {
		this.stateName = newStateName;
		cities = new ArrayList<City>();
	}
	
	public void addCity (City newCity) {
		cities.add(newCity);
	}
}
