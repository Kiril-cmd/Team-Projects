package geographyProject.RegionHyrarchy;

public class City extends GovernedRegion{
	private long zipCode;
	private String Mayor;
	private String country;
	private String state;
		
	public City(String name) {
		super(name);
	}
	

	// getters & setters
	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getMayor() {
		return Mayor;
	}

	public void setMayor(String mayor) {
		Mayor = mayor;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
