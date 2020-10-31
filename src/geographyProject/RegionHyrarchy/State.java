package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class State extends MultiLocalities {
	private Country country;
		
	public State (String name) {
		super(name);
	}

	// getter & setter
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
