package geographyProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import geographyProject.RegionHyrarchy.City;
import geographyProject.RegionHyrarchy.Country;
import geographyProject.RegionHyrarchy.GovernedRegion;
import geographyProject.RegionHyrarchy.State;
import geographyProject.RegionHyrarchy.GovernedRegion.FormOfGovernment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GeoModel {
	
	public final ObservableList<Country> countries = FXCollections.observableArrayList();
	public final ObservableList<State> states = FXCollections.observableArrayList();
	public final ObservableList<City> cities = FXCollections.observableArrayList();
	
	private int searchIndex;
	private int listIndex;
	private boolean foundIndex;
	
	private boolean[] userInputValid;
	
	private final String SEPARATOR = ";";
	private final String GEO_FILE = "GeoFile";

	
	public void addCountry (String newCountry) {
		countries.add(new Country(newCountry));
	}
	
	public boolean doubleCheckerCountry(String countryName) {
		listIndex = getCountryIndex(countryName);
		return foundIndex;	
	}
	
	public boolean doubleCheckerState(String stateName) {
		listIndex = getStateIndex(stateName);
		return foundIndex;
	}
	
	public boolean doubleCheckerCity(String cityName) {
		listIndex = getCityIndex(cityName);
		return foundIndex;
	}
	
	public void addState (String newState, String country) {
		states.add(new State(newState, country));
	}
	
	public void addCity (String newCity, String state) {
		cities.add(new City(newCity, state));
	}
	
	// Method saves entered user inputData (Country) in the concerning object
	public void saveCountryData(String countryName, String[] userInput, FormOfGovernment formOfGovernment) {
		listIndex = getCountryIndex(countryName);
		userInputValid = validateUserInput(userInput);
		
		if (userInputValid[0])
			countries.get(listIndex).setPopulation(Integer.parseInt(userInput[0]));
		if (userInputValid[1])
			countries.get(listIndex).setArea(Integer.parseInt(userInput[1]));
		if (formOfGovernment != null)
			countries.get(listIndex).setFormOfGovernment(formOfGovernment);
		if (userInputValid[2])
			countries.get(listIndex).setLanguages(userInput[2].toString());
		if (userInputValid[3])
			countries.get(listIndex).setCurrency(userInput[3].toString());
		if (userInputValid[4])
			countries.get(listIndex).setPhoneCode(userInput[4].toString());
		if (userInputValid[5])
			countries.get(listIndex).setCapitalCity(userInput[5].toString());
		if (userInputValid[6])
			countries.get(listIndex).setHistory(userInput[6].toString());
	}
	
	public void saveStateData(String stateName, String[] userInput) {
		listIndex = getStateIndex(stateName);
		userInputValid = validateUserInput(userInput);
		
		if (userInputValid[0])
			states.get(listIndex).setPopulation(Integer.parseInt(userInput[0]));
		if (userInputValid[1])
			states.get(listIndex).setArea(Integer.parseInt(userInput[1]));
		if (userInputValid[2])
			states.get(listIndex).setMaxElevation(Integer.parseInt(userInput[2]));
		if (userInputValid[3])
			states.get(listIndex).setMinElevation(Integer.parseInt(userInput[3]));
		if (userInputValid[4])
			states.get(listIndex).setLanguages(userInput[4]);
		if (userInputValid[5])
			states.get(listIndex).setCapitalCity(userInput[5].toString());
		if (userInputValid[6])
			states.get(listIndex).setHistory(userInput[6].toString());
		
		states.get(listIndex).setAvgElevation();
	}
	
	public void saveCityData(String cityName, String[] userInput) {
		listIndex = getCityIndex(cityName);
		userInputValid = validateUserInput(userInput);
		
		if (userInputValid[0])
			cities.get(listIndex).setPopulation(Integer.parseInt(userInput[0]));
		if (userInputValid[1])
			cities.get(listIndex).setArea(Integer.parseInt(userInput[1]));
		if (userInputValid[2])
			cities.get(listIndex).setMaxElevation(Integer.parseInt(userInput[2]));
		if (userInputValid[3])
			cities.get(listIndex).setMinElevation(Integer.parseInt(userInput[3]));
		if (userInputValid[4])
			cities.get(listIndex).setLanguages(userInput[4]);
		if (userInputValid[5])
			cities.get(listIndex).setZipCode(Integer.parseInt(userInput[5]));
		if (userInputValid[6])
			cities.get(listIndex).setMayor(userInput[6].toString());
		if (userInputValid[7])
			cities.get(listIndex).setHistory(userInput[7].toString());
		
		cities.get(listIndex).setAvgElevation();
	}
	
	private boolean[] validateUserInput(String[] userInput) {
		boolean[] userInputValid = new boolean[userInput.length];
		
		for (int i = 0; i < userInput.length; i++) {
			if (userInput[i] != null && !userInput[i].equals("0") && !userInput[i].equals("0.0"))
				userInputValid[i] = true;
			else
				userInputValid[i] = false;	
		}
		return userInputValid;
	}
	
	public void deleteCountry(String countryName) {
		if (countries.size() > 0 ) {
		listIndex = getCountryIndex(countryName);
		countries.remove(listIndex);
		}
	}
	
	public void deleteState(String stateName) {
		if (states.size() > 0) {
		listIndex = getStateIndex(stateName);
		states.remove(listIndex);
		}
	}
	
	public void deleteCity(String cityName) {
		if (cities.size() > 0) {
		listIndex = getCityIndex(cityName);
		cities.remove(listIndex);
		}
	}
	
	public Country getCountry(String countryName) {
		listIndex = getCountryIndex(countryName);
		Country country = countries.get(listIndex);
		
		return country;
		
	}
	
	public State getState(String stateName) {
		listIndex = getStateIndex(stateName);
		State state = states.get(listIndex);
		
		return state;
	}
	
	public City getCity(String cityName) {
		listIndex = getCityIndex(cityName);
		City city = cities.get(listIndex);
		
		return city;
	}
		
	// getCountryIndex, getStateIndex and getCityIndex methods search the index of the searchName in the ArrayList
	public int getCountryIndex(String countrySearchName) {
		searchIndex = -1;
		foundIndex = false;
		
		for (int i = 0; i < countries.size() && foundIndex == false; i++) {
			if (countries.get(i).getName().equals(countrySearchName)) {
				searchIndex = i;
				foundIndex = true;
			}	
		}		
		return searchIndex;
	}
	
	public int getStateIndex(String stateSearchName) {
		searchIndex = -1;
		foundIndex = false;
		
		for (int i = 0; i < states.size() && foundIndex == false; i++) {
			if (states.get(i).getName().equals(stateSearchName)) {
				searchIndex = i;
				foundIndex = true;
			}	
		}
		return searchIndex;
	}
	
	public int getCityIndex(String citySearchName) {
		searchIndex = -1;
		foundIndex = false;
		
		for (int i = 0; i < cities.size() && foundIndex == false; i++) {
			if (cities.get(i).getName().equals(citySearchName)) {
				searchIndex = i;
				foundIndex = true;
			}	
		}
		return searchIndex;
	}
	
	public void loadGeo () {
		File geoFile = new File (GEO_FILE);
		try (Reader inReader = new FileReader(geoFile)) {
			BufferedReader in = new BufferedReader(inReader);
			//countries = new ArrayList<Country>();
			
			String line = in.readLine();
			while (line != null) {
				Country country = readCountry(line);
				countries.add(country);
				line = in.readLine();
			}
		} catch (Exception e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	private Country readCountry (String line) {
		String[] attributes = line.split(SEPARATOR);
		String name = attributes[0];
		long population = Long.parseLong(attributes[1]);
		Country country = new Country(name);
		country.setName(name);
		country.setPopulation(population);
		return country;
	}
	
	public void saveGeo () {
		File geoFile = new File(GEO_FILE);
		try (Writer out = new FileWriter(geoFile)) {
			for (Country country : countries) {
				String line = writeCountry(country);
				out.write(line);
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String writeCountry (Country country) {
		String line = country.getName() + SEPARATOR + country.getPopulation() + "\n";
		return line;
	}
	
	
}
