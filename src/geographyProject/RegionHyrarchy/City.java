package geographyProject.RegionHyrarchy;

public class City extends GovernedRegion{
	private long zipCode;
	private String Mayor;
	private String state;
		
	public City (String name, String state) {
		super(name);
		this.state = state;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
		
}
