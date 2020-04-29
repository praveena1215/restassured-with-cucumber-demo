@weather 
Feature: Get weather by CITY 
Scenario Outline: User calls web service to get weather by its city 
	Given a weather exists with a city of <cityname> 
	When a user retrieves the weather by city 
	Then the weather status code is 200 
	
		Examples: 
		|cityname |
		| Chennai |
		|Mumbai   |
		| Coimbatore|
		| Trichy |
	