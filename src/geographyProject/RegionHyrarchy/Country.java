package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class Country extends GovernedRegion{
	private String currency;
	private String phoneCode;	
	ArrayList<State> states;
	
	public Country(String name) {
		super(name);
		this.states = new ArrayList<State>();
	}
	
	public void addState (State newState) {
		states.add(newState);
	}

}
