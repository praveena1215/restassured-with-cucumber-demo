@ResponseAttributes 
Feature: To check the weather API response 
Scenario Outline: 
	To ensure expected attributes and values are listed for the search city 
	Given a weather exists with a city of <cityname> 
	When a user retrieves the weather by city 
	Then the weather status code is 200 
	And the expected attributes are below 
	    
		|location.region| Tamil Nadu |
		|location.country| India|	
		|location.timezone_id| Asia/Kolkata |
		
			
	Examples: 
		|cityname |
		| Chennai |
		