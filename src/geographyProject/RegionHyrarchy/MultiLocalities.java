package geographyProject.RegionHyrarchy;

public abstract class MultiLocalities extends GovernedRegion {
	private String capitalCity;
	
	public MultiLocalities(String name) {
		super(name);
	}

	// getters & setters
	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

}
