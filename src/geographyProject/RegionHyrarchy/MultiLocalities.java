package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public abstract class MultiLocalities extends GovernedRegion {
	private String capitalCity;
	private ArrayList<City> cities;
	
	public MultiLocalities(String name) {
		super(name);
		this.cities = new ArrayList<City>();
	}
	
	public void addCity (City newCity) {
		cities.add(newCity);
	}
	

}
