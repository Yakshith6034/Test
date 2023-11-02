package stepDefinitions;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Patch

{

	String baseUrl = "https://jsonplaceholder.typicode.com/posts/";

	RequestSpecification requestSpecification;
	Response response;
	ResponseBody responseBody;

	@Given("Read the baseUrl with Endpoint")
	public void read_the_base_url_with_endpoint()

	{
		requestSpecification = RestAssured.given().baseUri("https://jsonplaceholder.typicode.com/posts/");

	}

	@When("Add the Headers to API")
	public void add_the_headers_to_api() {
		requestSpecification.header("Content-Type", "application/json");

	}

	@And("Provide  Query Parameters")
	public void provide_query_parameters() {
		String patchRequestBody = "{ \"title\": \"Updated Title Patch\", \"body\": \"Updated Body\", \"userId\": 1 }";

		Response patchResponse = RestAssured.given().contentType(ContentType.JSON).body(patchRequestBody).when()
				.patch("https://jsonplaceholder.typicode.com/posts/1");
		System.out.println("patch Response Status Code: " + patchResponse.getStatusCode());
	}

	@Then("Validate the patch response")
	public void validate_the_patch_response() {

		Response getResponse = RestAssured.given().contentType(ContentType.JSON).when()
				.get("https://jsonplaceholder.typicode.com/posts/1");

		System.out.println("GET Response Status Code==========>: " + getResponse.getStatusCode());

		System.out.println("GET Response Body: " + getResponse.getBody().asString());

	}

}
