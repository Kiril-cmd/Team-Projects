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
	
	private final String SEPARATOR = ";";
	private final String GEO_FILE_COUNTRY = "GeoFileCountry";
	private final String GEO_FILE_STATE = "GeoFileState";
	private final String GEO_FILE_CITY = "GeoFileCity";

	
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
	
	public void loadGeo () {
		File geoFileCountry = new File (GEO_FILE_COUNTRY);
		if (geoFileCountry.exists()) {
			try (Reader inReader = new FileReader(geoFileCountry)) {
				BufferedReader in = new BufferedReader(inReader);
				
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
			
		File geoFileState = new File (GEO_FILE_STATE);
					
		if (geoFileState.exists()) {
			try (Reader inReader = new FileReader(geoFileState)) {
				BufferedReader in = new BufferedReader(inReader);
				
				String line = in.readLine();
				while (line != null) {
					State state= readState(line);
					states.add(state);
					line = in.readLine();
				}
			} catch (Exception e) {
				System.out.println("An error occurred");
				e.printStackTrace();
			}
		File geoFileCity = new File (GEO_FILE_CITY);
		
		if (geoFileCity.exists()) {
			try (Reader inReader = new FileReader(geoFileCity)) {
				BufferedReader in = new BufferedReader(inReader);
				
				String line = in.readLine();
				while (line != null) {
					City city = readCity(line);
					cities.add(city);
					line = in.readLine();
				}
			} catch (Exception e) {
				System.out.println("An error occurred");
				e.printStackTrace();
			}
		}
		}
		}
	}
	
	private Country readCountry (String line) {
		String[] attributes = line.split(SEPARATOR);
		String name = attributes[0];
		long population = Long.parseLong(attributes[1]);
		int area = Integer.parseInt(attributes[2]);
		FormOfGovernment formofgovernment = FormOfGovernment.valueOf(attributes[3]);
		String languages = attributes[4];
		String currency = attributes[5];
		String phoneCode = attributes[6];
		String capitalCity = attributes[7];
		String history = attributes[8];
		
		Country country = new Country(name);
		country.setName(name);
		country.setPopulation(population);
		country.setArea(area);
		country.setFormOfGovernment(formofgovernment);
		country.setLanguages(languages);
		country.setCurrency(currency);
		country.setPhoneCode(phoneCode);
		country.setCapitalCity(capitalCity);
		country.setHistory(history);
				
		return country;
	}
	
	private State readState (String line) {
		String[] attributes = line.split(SEPARATOR);
		String name = attributes[0];
		String country = attributes[1];
		long population = Long.parseLong(attributes[2]);
		int area = Integer.parseInt(attributes[3]);
		double maxElevation = Double.parseDouble(attributes [4]);
		double minElevation = Double.parseDouble(attributes[5]);
		String languages = attributes[6];
		String capitalCity = attributes[7];
		String history = attributes[8];
		
		
		State state = new State(name, country);
		state.setName(name);
		state.setCountry(country);
		state.setPopulation(population);
		state.setArea(area);
		state.setMaxElevation(maxElevation);
		state.setMinElevation(minElevation);
		state.setAvgElevation();
		state.setLanguages(languages);
		state.setCapitalCity(capitalCity);
		state.setHistory(history);
		
		return state;
	}
	
		
	private City readCity (String line) {
		String[] attributes = line.split(SEPARATOR);
		String name = attributes[0];
		String state = attributes[1];
		long population = Long.parseLong(attributes[2]);
		int area = Integer.parseInt(attributes[3]);
		double maxElevation = Double.parseDouble(attributes [4]);
		double minElevation = Double.parseDouble(attributes[5]);
		String languages = attributes[6];
		long zipCode = Long.parseLong(attributes[7]);
		String mayor = attributes[8];
		String history = attributes[9];
		
		City city = new City(name, state);
		city.setName(name);
		city.setState(state);
		city.setPopulation(population);
		city.setArea(area);
		city.setMaxElevation(maxElevation);
		city.setMinElevation(minElevation);
		city.setLanguages(languages);
		city.setZipCode(zipCode);
		city.setMayor(mayor);
		city.setHistory(history);
				
		return city;
	}
	
	public void saveGeo () {
		File geoFileCountry = new File(GEO_FILE_COUNTRY);
		try (Writer out = new FileWriter(geoFileCountry)) {
			for (Country country : countries) {
				String line = writeCountry(country);
				out.write(line);
//				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File geoFileState = new File(GEO_FILE_STATE);
		try (Writer out = new FileWriter(geoFileState)) {
			for (State state : states) {
				String line = writeState(state);
				out.write(line);
//				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File geoFileCity = new File(GEO_FILE_CITY);
		try (Writer out = new FileWriter(geoFileCity)) {
			for (City city: cities) {
				String line = writeCity(city);
				out.write(line);
//				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String writeCountry (Country country) {
		String line = country.getName() + SEPARATOR + country.getPopulation() + SEPARATOR + country.getArea() + SEPARATOR + 
				country.getFormOfGovernment() + SEPARATOR + country.getLanguages() + SEPARATOR + country.getCurrency() + 
				SEPARATOR + country.getPhoneCode() + SEPARATOR + country.getCapitalCity() + SEPARATOR +
				country.getHistory() + "\n";
		return line;
	}
	
	private String writeState (State state) {
		String line = state.getName() + SEPARATOR + state.getCountry() + SEPARATOR + state.getPopulation() + SEPARATOR + 
				state.getArea() + SEPARATOR + state.getMaxElevation() + SEPARATOR + state.getMinElevation() + 
				SEPARATOR + state.getLanguages() + SEPARATOR + state.getCapitalCity() + SEPARATOR + state.getHistory()
				+ "\n";
		return line;
	}
	
	private String writeCity (City city) {
		String line = city.getName() + SEPARATOR + city.getState() + SEPARATOR + city.getPopulation() + SEPARATOR + 
				city.getArea() + SEPARATOR + city.getMaxElevation() + SEPARATOR + city.getMinElevation() + SEPARATOR +
				city.getLanguages() + SEPARATOR + city.getZipCode() + SEPARATOR + city.getMayor() + SEPARATOR +
				city.getHistory() + "\n";
		return line;
	}
		
}
