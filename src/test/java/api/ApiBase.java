package api;

import io.restassured.RestAssured;

public class ApiBase {

    public static void setup() {
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
