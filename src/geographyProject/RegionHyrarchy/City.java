package geographyProject.RegionHyrarchy;

public class City extends GovernedRegion{
	private long zipCode;
	private String Mayor;
	private Country country;
	private State state;
		
	public City (String name) {
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
