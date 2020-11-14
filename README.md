# Team-Projects

Geo Database by Leandro Hoenen and Kiril Buga

Additional classes: City, MultiLocalities
Additional attributes: currency, phoneCode, languages, history, maxElevation, minElevation, avgElevation, zipCode,Mayor, capitalCity

Functions:
	
	Tabs: 
	The software starts in country tab. As soon as a country is selected the state tab is available, as soon as a state is selected the city tab is available.
	The software displays only related states to a specific selected country and only related cities to a specific selected state.
	
	Center View:
	The view on the right side adapts to the selection of the user (tabs: country, state, city) and displays the data concerning the selected item.
	Each level has its own view on the right side (3 views: country, state, city).
	If no item is selected the default view is displayed. The center view is enabled only if Edit button is toggled.
	
	TextFields:
		EnterZone: Countries, states and cities can be created via this text field. 
		SearchField: SearchField is located under the item list. It allows to search for items in every tab independently (Case insensitive).
		It searches for all items containing the entered characters in the field. No buttons need to be clicked to search.
	
	Delete button: It allows to delete all sub items. If a country is deleted then all states and cities within this country will be also deleted.
	
	Scroll area: The user user can freely scroll the center view.
	
	Save/Load function: The software saves in external files new items (countries, states and cities) when entered via create button.
	But it also saves the center view data when save button is clicked. It loads all data automatically at the start of the program.
	An example with 3 countries is provided.
	Delete button erases data from data files.
	
	Average Elevation: Average Elevation field under state and city view calculates the Average Elevation in real time.

Good user interface usability:
	Buttons:
		Edit: edit button is toggled when clicked and activated only if an item is selected. The tabs on the left side are deactivated when edit button is toggled
		so that the user can't change the view in toggle mode.
		Save: save button is only activated when edit button is toggled.
		Delete: delete button is deactivated when edit button is toggled.
	DoubleChecker: the software prevents the user from entering a country twice.
	It might happen that states and cities have the same name in different countries (for example: Springfield, Origon, Springfield, New York etc).
	However, the software prevents the user from entering twice the same state in a single country and twice the same city in a single state. 
	EnterZone: prevents user from creating items with spaces at the beginning or at the end.
	Center View: An alarm appears if entered data is invalid (for example: unnecessary spaces, text instead of numbers etc.)

