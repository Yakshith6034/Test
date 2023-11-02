package stepDefinitions;

import org.json.JSONArray;
import org.junit.Assert;
import org.json.JSONObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class DeleteItem {

    String baseUri = "https://bookcart.azurewebsites.net/";
    String endPoint = "api/shoppingcart/897/";

    RequestSpecification requestSpecification;
    Response response;
    ResponseBody responseBody;
    Response Delete;

    @Given("Read Base URL with Endpoint for the cart delete API")
    public void readBaseUrlWithEndpoint() {
        requestSpecification = RestAssured.given().baseUri(baseUri + endPoint);
    }

    @When("Add the Headers for the cart delete API")
    public void addTheHeaders() {
        requestSpecification.header("Content-Type", "application/json");
    }

    @Then("Validate the Delete Response")
    public void validateDeleteResponse() {
        try {
            Response response = requestSpecification.get();

            System.out.println("Status Code for GET request========> " + response.getStatusCode());

            ResponseBody responseBody = response.getBody();
            String responseString = responseBody.asPrettyString();
            System.out.println("Response ::::: " + responseString);

            Response responseDelete = requestSpecification.delete();

            System.out.println("Status Code for DELETE request: " + responseDelete.getStatusCode());

            ResponseBody responseBodyDelete = responseDelete.getBody();
            String responseStringDelete = responseBodyDelete.asPrettyString();

            if (responseStringDelete.isEmpty()) {
                System.out.println("DELETE response is empty.");
            } else {
                System.out.println("DELETE response is not empty.");
            }
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
            // You can add more specific exception handling as needed
        }
    }
}
