package api;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class ApiSteps {

    Response response;

    @Before("@api")
    public void init() {
        ApiBase.setup();
    }

    @Given("User sends GET request to {string}")
    public void user_sends_get_request(String endpoint) {
        response = given()
                .header("Accept", "application/json")
                .when()
                .get("https://reqres.in/api/users?page=2");

        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }


    @Then("Status code should be {int}")
    public void status_code_should_be(Integer code) {
        assertEquals(response.getStatusCode(), code.intValue());
    }
}
