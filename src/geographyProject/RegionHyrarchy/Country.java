package geographyProject.RegionHyrarchy;

public class Country extends MultiLocalities {
	private String currency;
	private String phoneCode;
	
	public Country(String name) {
		super(name);
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

}
