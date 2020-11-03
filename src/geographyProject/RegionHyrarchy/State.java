package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class State extends MultiLocalities {
	private String country;
	
	private final int idState; 
	private static int idCounter = -1; 
	
	
		
	public State (String name, String country) {
		super(name);
		this.country= country;
		idState = ++idCounter;
		
	}

	// getter & setter
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getId() {
		return idState;
	}
}
