package geographyProject;

import geographyProject.RegionHyrarchy.Country;
import geographyProject.RegionHyrarchy.State;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import geographyProject.RegionHyrarchy.City;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;


public class GeoController {
	private GeoModel model;
	private GeoView view;

	private Tab currentTab = new Tab ();
	
	private String lastSelectedCountry;
	private String lastSelectedState;
	private String lastSelectedCity;
	
	public GeoController(GeoModel model, GeoView view) {
		this.model = model;
		this.view = view;
		
		// Set selected tab to country when launching the first time
		currentTab = view.tabCountry;
		
		topControlsEvents();
		leftControlsEvents();
	}
	
	private void topControlsEvents() {
		// Button events
		view.btnCreate.setOnMouseClicked(this::create);
		view.btnEdit.setOnMouseClicked(this::edit);
		view.btnSave.setOnMouseClicked(this::save);
		
		// Listeners
		view.btnEdit.disableProperty().bind(Bindings.isEmpty(view.itemList.getSelectionModel().getSelectedItems()));
	}

	private void leftControlsEvents () {
		
		disableTabs();
				
		// Track the current tab selection
		view.tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
						
			currentTab = newValue;
			disableTabs();
			
			updateView(currentTab);
			
		});
		
		// Track the current item selection
		view.itemList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
	
			// Unblock tabs if an item is selected
			 
			if (currentTab == view.tabCountry)
			{
				lastSelectedCountry = newValue;
				if(view.itemList.getSelectionModel().isEmpty() == false && lastSelectedCountry != null ) {
					view.tabState.setDisable(false);
				}
					
				
				
			} 
			else if (currentTab == view.tabState) {
				lastSelectedState = newValue;
				if(view.itemList.getSelectionModel().isEmpty() == false && lastSelectedState != null ) {
					view.tabCity.setDisable(false);
				}
				
			} 
			else if (currentTab == view.tabCity) {
				lastSelectedCity = newValue;
				view.tabCountry.setDisable(false);
				view.tabState.setDisable(false);
				
			}
		
			 		
		});
	}
	
	private void create(MouseEvent e) {
		// Country, state or city
		String entry = view.tfEnterZone.getText();
		
		
		
		// Create Country
		if(view.tabPane.getSelectionModel().getSelectedItem() == view.tabCountry) {
			if (entry.length() > 0 && !entry.contains(" ")) {
				model.addCountry(entry); 
				updateView(view.tabPane.getSelectionModel().getSelectedItem());
			} else {
				view.alertEntry.showAndWait();
			}
		}
		// Create State
		else if(view.tabPane.getSelectionModel().getSelectedItem() == view.tabState) {					
			if (entry.length() > 0 && !entry.contains(" ")) {
				model.addState(entry, lastSelectedCountry); 
				updateView(view.tabPane.getSelectionModel().getSelectedItem());
			} else {
				view.alertEntry.showAndWait();
			}
		}
		// Create City
		else if(view.tabPane.getSelectionModel().getSelectedItem() == view.tabCity) {
			if (entry.length() > 0 && !entry.contains(" ")) {
				model.addCity(entry, lastSelectedState); 
				updateView(view.tabPane.getSelectionModel().getSelectedItem());
			} else {
				view.alertEntry.showAndWait();
			}
		}
		
		
		// tfEnterZone is empty after every entry
		view.tfEnterZone.setText("");
	}

	private void edit(MouseEvent e) {
		if (view.itemList.getSelectionModel().getSelectedItem() != null && view.tabPane.getSelectionModel().getSelectedItem() == view.tabCountry) {
			for (int i = 0; i < view.centerRoot.controlsCountry.length; i++) {
				view.centerRoot.controlsCountry[i].setDisable(false);
			}
			// Disable item selection and tabs switching when editing
			view.itemList.setMouseTransparent(true);
			view.itemList.setFocusTraversable(false);
			view.tabState.setDisable(true);
			view.tabCity.setDisable(true);
		}
		else if(view.itemList.getSelectionModel().getSelectedItem() != null && view.tabPane.getSelectionModel().getSelectedItem() == view.tabState) {
			for (int i = 0; i < view.centerRoot.controlsState.length; i++) {
				view.centerRoot.controlsState[i].setDisable(false);
			}
			view.itemList.setMouseTransparent(true);
			view.itemList.setFocusTraversable(false);
			view.tabCountry.setDisable(true);
			view.tabCity.setDisable(true);
		}
		else if (view.itemList.getSelectionModel().getSelectedItem() != null && view.tabPane.getSelectionModel().getSelectedItem() == view.tabCity) {
			for (int i = 0; i < view.centerRoot.controlsCity.length; i++) {
				view.centerRoot.controlsCity[i].setDisable(false);
			}
			view.itemList.setMouseTransparent(true);
			view.itemList.setFocusTraversable(false);
			view.tabCountry.setDisable(true);
			view.tabState.setDisable(true);
		}
		
	}
	
	private void save(MouseEvent e) {
		// Enable all tabs and item selection again
		view.tabCountry.setDisable(false);
		view.tabState.setDisable(false);
		view.tabCity.setDisable(false);
		view.itemList.setMouseTransparent(false);
		view.itemList.setFocusTraversable(true);
	}
	

	private void updateView (Tab currentTab) {
		
		view.items.clear();
		
		if (currentTab == view.tabCountry ) {
			for (int i = 0; i < model.countries.size(); i++) {
				Country country = model.countries.get(i);
				String countryText = country.getName();
				view.items.add(countryText);
			}
		} else if (currentTab == view.tabState) {
			for(int i = 0; i < model.states.size(); i++) {
				State state = model.states.get(i);
				if (lastSelectedCountry == state.getCountry())
				{
					String stateText = state.getName();
					view.items.add(stateText);
				}
			}
			
		} else if (currentTab == view.tabCity ) {
			for(int i = 0; i < model.cities.size(); i++) {
				City city = model.cities.get(i);
				if (lastSelectedState == city.getState())
				{
					String cityText = city.getName();
					view.items.add(cityText);
				}
			}
			
		} 
		view.showCenterView(currentTab);		
	}
	
	private void disableTabs () {
		// Disable Tabs
		if (currentTab == view.tabCountry) {
			view.tabState.setDisable(true);
			view.tabCity.setDisable(true);
		} else if (currentTab == view.tabState) {
			view.tabCity.setDisable(true);
		}
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
