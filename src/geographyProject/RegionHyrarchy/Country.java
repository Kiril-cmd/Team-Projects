package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public class Country extends MultiLocalities {
	private String currency;
	private String phoneCode;	
	private ArrayList<State> states;
	private final int idCountry;
	private static int idCounter = -1;
	
	public Country(String name) {
		super(name);
		this.states = new ArrayList<State>();
		idCountry = ++idCounter;
	}
	
	public void addState (State newState) {
		states.add(newState);
	}
	
	public void removeState (State obsoleteState) {
		states.remove(obsoleteState);
	}

	// getters & setters
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public ArrayList<State> getStates() {
		return states;
	}
	
	public int getId() {
		return idCountry;
	}
	
	

}
