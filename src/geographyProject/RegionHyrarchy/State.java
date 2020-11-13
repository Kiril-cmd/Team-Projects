package geographyProject.RegionHyrarchy;

public class State extends MultiLocalities {
	private String country;
		
	public State (String name, String country) {
		super(name);
		this.country= country;	
	}

	// getter & setter
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
