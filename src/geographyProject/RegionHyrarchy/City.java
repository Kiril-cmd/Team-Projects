package geographyProject.RegionHyrarchy;

public class City extends GovernedRegion{
	String cityName;
	int highestElevation;
	int averageElevation;
	int zip;
	String Mayor;
	
	public City (String newCityName) {
		this.cityName = newCityName;
	}
	
}
