package stepDefinitions;

import org.json.JSONArray;


import org.json.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetSteps {

    String baseUri = "https://srivarisevaapi.tirumala.org/";
    String endPoint = "Configuration/GetStateDistrictList";

    RequestSpecification requestSpecification;
    Response response;
    ResponseBody responseBody;

    @Given("Read Base url with endpoint")
    public void Read_the_base_url_with_Endpoint() 
    {
        try {
            requestSpecification = RestAssured.given().baseUri(baseUri + endPoint);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }

    @When("Add the Headers")
    public void Add_the_headers() 
    {
        try {
            requestSpecification.header("Content-Type", "application/json");
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }
    
    
    @Then("Validate the Get Response")
    public void Validate_the_Get_response() {
        try {
            Response response = requestSpecification.get();

            System.out.println("Status Code for GET request========> " + response.getStatusCode());

            ResponseBody responseBody = response.getBody();
            String responseString = responseBody.asPrettyString();
            System.out.println("Response :::::" + responseString);

            String districtToValidate = "Yanam"; // Change this to the district you want to validate

//            JSONArray jsonArray = new JSONArray(responseString);
//            boolean found = false;
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject districtObj = jsonArray.getJSONObject(i);
//                String districtName = districtObj.getString("DistrictName");
//                int stateId = districtObj.getInt("StateId");
//                int did = districtObj.getInt("Did");
//
//                System.out.println("District Name: " + districtName);
//                System.out.println("StateId: " + stateId);
//                System.out.println("Did: " + did);
//
//                if (districtName.equals(districtToValidate)) {
//                    found = true;
//                    System.out.println("Response contains the district: " + districtToValidate);
//                    break; // Exit the loop once the district is found
//                }
//            }
//
//            if (!found) {
//                System.out.println("Response does not contain the district: " + districtToValidate);
//            }
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }
}
