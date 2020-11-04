package geographyProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	
	public void addCountry (String newCountry) {
		listIndex = getCountryIndex(newCountry);
		countries.add(new Country(newCountry));
	}
	
//	public boolean 
	
	public void addState (String newState, String country) {
		states.add(new State(newState, country));
	}
	
	public void addCity (String newCity, String state) {
		cities.add(new City(newCity, state));
	}
	
	// Method saves entered user inputData (Country) in the concerning object
	public void saveCountryData(String countryName, String[] userInput, FormOfGovernment formOfGovernment) {
		listIndex = getCountryIndex(countryName);
		
		countries.get(listIndex).setPopulation(Integer.parseInt(userInput[0]));
		countries.get(listIndex).setArea(Integer.parseInt(userInput[1]));
		countries.get(listIndex).setFormOfGovernment(formOfGovernment);
		countries.get(listIndex).setLanguages(userInput[2].toString());
		countries.get(listIndex).setCurrency(userInput[3].toString());
		countries.get(listIndex).setPhoneCode(userInput[4].toString());
		countries.get(listIndex).setCapitalCity(userInput[5].toString());
		countries.get(listIndex).setHistory(userInput[6].toString());
	}
	
	public void saveStateData(String stateName, String[] userInput) {
		listIndex = getStateIndex(stateName);
		
		states.get(listIndex).setPopulation(Integer.parseInt(userInput[0]));
		states.get(listIndex).setArea(Integer.parseInt(userInput[1]));
		states.get(listIndex).setMaxElevation(Integer.parseInt(userInput[2]));
		states.get(listIndex).setMinElevation(Integer.parseInt(userInput[3]));
		states.get(listIndex).setAvgElevation();
		states.get(listIndex).setLanguages(userInput[4]);
		states.get(listIndex).setCapitalCity(userInput[5].toString());
		states.get(listIndex).setHistory(userInput[6].toString());		
	}
	
	public void saveCityData(String cityName, String[] userInput) {
		listIndex = getCityIndex(cityName);
		
		cities.get(listIndex).setPopulation(Integer.parseInt(userInput[0]));
		cities.get(listIndex).setArea(Integer.parseInt(userInput[1]));
		cities.get(listIndex).setMaxElevation(Integer.parseInt(userInput[2]));
		cities.get(listIndex).setMinElevation(Integer.parseInt(userInput[3]));
		cities.get(listIndex).setAvgElevation();
		cities.get(listIndex).setLanguages(userInput[4]);
		cities.get(listIndex).setZipCode(Integer.parseInt(userInput[5]));
		cities.get(listIndex).setMayor(userInput[6].toString());
		cities.get(listIndex).setHistory(userInput[7].toString());
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
			if (countries.get(i).getName() == countrySearchName) {
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
			if (states.get(i).getName() == stateSearchName) {
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
			if (cities.get(i).getName() == citySearchName) {
				searchIndex = i;
				foundIndex = true;
			}	
		}
		return searchIndex;
	}
	
	private void createFile () {
		try {
			File newFile = new File ("Data.txt");
			if (newFile.createNewFile()) {
				System.out.println("File created: " + newFile.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	private void writeToFile () {
		try {
		      FileWriter myWriter = new FileWriter("Data.txt");
		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      }
	}
	
	
}
