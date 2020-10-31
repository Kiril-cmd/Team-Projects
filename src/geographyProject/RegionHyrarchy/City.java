package geographyProject.RegionHyrarchy;

public class City extends GovernedRegion{
	String cityName;
	long zipCode;
	String Mayor;
	
	public City (String newCityName) {
		this.cityName = newCityName;
	}
	
}
