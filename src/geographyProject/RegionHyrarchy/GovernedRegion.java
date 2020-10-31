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
	private double maxElevation;
	private double minElevation;
	private double avgElevation;

	public GovernedRegion(String name){
			this.name = name;
			this.languages = new ArrayList<String>();
	}
	
	public void addLanguage(String newLanguage) {
		languages.add(newLanguage);
	}

	// getters & setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public long getPopulation() {
		return population;
	}
	
	public void setPopulation(long population) {
		this.population = population;
	}
	
	public FormOfGovernment getFormOfGovernment() {
		return formOfGovernment;
	}
	
	public void setFormOfGovernment(FormOfGovernment formOfGovernment) {
		this.formOfGovernment = formOfGovernment;
	}
	
	public ArrayList<String> getLanguages(){
		return languages;
	}
	
	public String getHistory() {
		return history;
	}
	
	public void setHistory(String history) {
		this.history = history;
	}
	
	public double getMaxElevation() {
		return maxElevation;
	}
	
	public void setMaxElevation(double maxElevation) {
		this.maxElevation = maxElevation;
	}
	
	public double getMinElevation() {
		return minElevation;
	}
	
	public void setMinElevation(double minElevation) {
		this.minElevation = minElevation;
	}
	
	public double getAvgElevation() {
		return avgElevation;
	}
	
	// sets avgElevation by using maxElevation & minElevation
	public void setAvgElevation() {
		if (maxElevation > 0 & minElevation > 0) {
			this.avgElevation = (maxElevation + minElevation) / 2;
		}
	}
	
}
