Feature: validation of Car Search page
	In order to validate car search
	as a buyer
	I navigate to Car Guide website
	
	Scenario: Searching for a new car
	
	Given I am on Homepage of CarGuide site
	When I move to "Buy + Sale" Menu
	And I click on Search Cars
	And I select Make as "BMW"
	And I select Model as "1 SERIES"
	And I select location as "Australia"
	And I select price as "$10,000"
	And I click on "Find My Next Car" button
	Then I should see list of searched cars from "BMW"
	And the page title should be "Bmw 1 Series Under 10000 for Sale | carsguide"
	