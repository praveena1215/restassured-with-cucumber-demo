@weather
Feature: Get weather by CITY
  Scenario: User calls web service to get weather by its city
	Given a weather exists with a city of "Mumbai"
	And a weather exists with a city of "Delhi"
	And a weather exists with a city of "chennai"
	When a user retrieves the weather by city
	Then the weather status code is 200
