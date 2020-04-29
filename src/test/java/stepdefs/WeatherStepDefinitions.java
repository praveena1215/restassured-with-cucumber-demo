package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class WeatherStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_BOOK_BY_ISBN = "http://api.weatherstack.com/current?access_key=4bb95b1299b55098b766112e7c1dff07";


	@Given("^a weather exists with a city of ([^\"]*)")
	public void a_weather_exists_with_a_city_of(String cityname){
		request = given().param("query", cityname);
		System.out.println("Entered city :" +cityname);
	}

	@When("^a user retrieves the weather by city$")
	public void a_user_retrieves_the_weather_by_city(){
		response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
		System.out.println("response: " + response.prettyPrint());
	}
	@Then("the weather status code is (\\d+)")
	public void verify_weather_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	
	}
	
	@And("the expected attributes are below")
	public void the_expected_attributes_are_below(Map<String,String> responseFields){
				for (Map.Entry<String, String> field : responseFields.entrySet()) {
			
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
				
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
				System.out.println("Expected keys & values :" +field);

				
			}
		}
	}
}


