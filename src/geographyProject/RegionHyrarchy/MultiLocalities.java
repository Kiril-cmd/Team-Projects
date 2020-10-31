package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public abstract class MultiLocalities extends GovernedRegion {
	private City capitalCity;
	private ArrayList<City> cities;
	
	public MultiLocalities(String name) {
		super(name);
		this.cities = new ArrayList<City>();
	}
	
	public void addCity (City newCity) {
		cities.add(newCity);
	}

	// getters & setters
	public City getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(City capitalCity) {
		this.capitalCity = capitalCity;
	}

	public ArrayList<City> getCities() {
		return cities;
	}
	

}
