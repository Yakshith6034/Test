package stepDefinitions;

import org.json.JSONArray;
import org.json.JSONObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Post {
    String baseUri = "https://www.redbus.in";
    String endPoint = "/search/SearchResults";

    RequestSpecification requestSpecification;
    Response response;
    ResponseBody responseBody;

    @Given("Read the base url with Endpoint")
    public void Read_the_base_url_with_Endpoint() {
        requestSpecification = RestAssured.given().baseUri(baseUri + endPoint);
    }

    @When("Add the headers")
    public void Add_the_headers() {
        requestSpecification.header("Content-Type", "application/json");
    }

    @And("Provide the Query Parameters")
    public void Provide_the_Query_Parameters() {
        requestSpecification.queryParam("fromCity", "124");
        requestSpecification.queryParam("toCity", "121");
        requestSpecification.queryParam("src", "Hyderabad");
        requestSpecification.queryParam("dst", "Anantapur%20(andhra%20pradesh)");
        requestSpecification.queryParam("DOJ", "10-Oct-2023");
        requestSpecification.queryParam("sectionId", "0");
        requestSpecification.queryParam("groupId", "0");
        requestSpecification.queryParam("limit", "0");
        requestSpecification.queryParam("offset", "0");
        requestSpecification.queryParam("sort", "0");
        requestSpecification.queryParam("sortOrder", "0");
        requestSpecification.queryParam("meta", "true");
        requestSpecification.queryParam("returnSearch", "0");
    }

    @Then("Validate the post response")
    public void Validate_the_post_response() {
        try {
            response = requestSpecification.post();
            int postStatusCode = response.getStatusCode();
            System.out.println("Post status code :::::" + postStatusCode);
            responseBody = response.getBody();

            String respoString = responseBody.asPrettyString();
            // System.out.println("Response :::::" + respoString);

            JSONObject responseObject = new JSONObject(respoString);

            JSONArray invJsonArray = responseObject.getJSONArray("inv");
            System.out.println("Json data ===>" + invJsonArray);

            JSONObject snObject = (JSONObject) invJsonArray.get(2);

            String snValue = snObject.getString("sn");

            String expectedSnvalue = "Hyderabad To Anantapur";
            System.out.println("snvalue ====> " + snValue);

            if (snValue.equals(expectedSnvalue)) {
                System.out.println("Your journey from " + expectedSnvalue + " Sucessfull");
            } else {
                System.out.println(expectedSnvalue + " No Matches found");
            }
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
            // You can add more specific exception handling as needed
        }
    }
}
