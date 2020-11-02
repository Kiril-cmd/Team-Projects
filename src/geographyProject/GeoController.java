package geographyProject;

import geographyProject.RegionHyrarchy.Country;
import geographyProject.RegionHyrarchy.GovernedRegion;
import geographyProject.RegionHyrarchy.State;
import geographyProject.RegionHyrarchy.City;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;

public class GeoController {
	private GeoModel model;
	private GeoView view;

	public GeoController(GeoModel model, GeoView view) {
		this.model = model;
		this.view = view;
		
		leftControlsEvents();
		topControlsEvents();
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
		view.tabPane.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
			updateView(newValue);
        });
	}
	
	private void create(MouseEvent e) {
		// Country, state or city
		String entry = view.tfEnterZone.getText();
					
		if(view.tabPane.getSelectionModel().getSelectedItem() == view.tabCountry) {
			if (entry.length() > 0 && !entry.contains(" ")) {
				model.addCountry(entry); 
				updateView(view.tabPane.getSelectionModel().getSelectedItem());
			} else {
				view.alertEntry.showAndWait();
			}
		} else if(view.tabPane.getSelectionModel().getSelectedItem() == view.tabState) {
										
			if (entry.length() > 0 && !entry.contains(" ")) {
				model.addState(entry); 
				updateView(view.tabPane.getSelectionModel().getSelectedItem());
			} else {
				view.alertEntry.showAndWait();
			}
		} else if(view.tabPane.getSelectionModel().getSelectedItem() == view.tabCity) {
			if (entry.length() > 0 && !entry.contains(" ")) {
				model.addCity(entry); 
				updateView(view.tabPane.getSelectionModel().getSelectedItem());
			} else {
				view.alertEntry.showAndWait();
			}
		}	
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
		
		String[] userInput;
		GovernedRegion inputClass;
		String itemName = view.itemList.getSelectionModel().getSelectedItem();
		
		if (view.tabCountry.isSelected()) {
			userInput = new String[view.centerRoot.controlsCountry.length];
			inputClass = new Country("");
			
			for (int i = 0; i < userInput.length; i++) {
				userInput[i] = ((TextInputControl) view.centerRoot.controlsCountry[i]).getText();
			}
		}
		
		
	}
	

	private void updateView (Tab newValue) {
		view.items.clear();
		
		if (newValue == view.tabCountry) {
			for (int i = 0; i < model.countries.size(); i++) {
				Country country = model.countries.get(i);
				String countryText = country.getName();
				view.items.add(countryText);
			}
		} else if (newValue == view.tabState) {
			for(int i = 0; i < model.states.size(); i++) {
				State state = model.states.get(i);
				String stateText = state.getName();
				view.items.add(stateText);
			}
		} else if (newValue == view.tabCity) {
			for(int i = 0; i < model.cities.size(); i++) {
				City city = model.cities.get(i);
				String cityText = city.getName();
				view.items.add(cityText);
			}
		}		
		view.showCenterView(newValue);		
	}

}
