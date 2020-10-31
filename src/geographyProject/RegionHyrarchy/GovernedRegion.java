package geographyProject.RegionHyrarchy;

import java.util.ArrayList;

public abstract class GovernedRegion {
	private String name;
	private int area;
	private long population;
	protected enum FormOfGovernment {Autocracy, Aristocracy, Democracy, Republics, Federalism}
	private FormOfGovernment formOfGovernment;
	private ArrayList<String> languages;
	private String history;
	private String currency;
	private double maxElevation;
	private double minElevation;
	private double avgElevation;

	public GovernedRegion(String name){
			this.name = name;
	}
	
	// sets avgElevation by using maxElevation & minElevation
	public void setAvgelevation() {
		if (maxElevation > 0 & minElevation > 0) {
			this.avgElevation = (maxElevation + minElevation) / 2;
		}
	}

	// getters
	public double getAvgElevation() {
		return avgElevation;
	}
}
