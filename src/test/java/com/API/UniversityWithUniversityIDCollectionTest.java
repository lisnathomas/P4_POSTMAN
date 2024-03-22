package com.API;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UniversityWithUniversityIDCollectionTest {

    @Test
    public void testIfGetStatusCode200() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/university261")
                .then()
                .statusCode(200);
       
    }
    
    @Test
    public void testIfResponseBodyIsNotEmptyForGet200response() {
        // Specify the base URI of your REST API
        RestAssured.baseURI = "http://127.0.0.1:4010";

        // Send a request and get the response
        Response response = RestAssured.given()
        		.header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("university261");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

        // Check if the response body is empty
        assertFalse(responseBody.isEmpty(), "Response body is empty");
    }
    
    @Test
    public void testIfPostResponseStatusCode201() {
        RestAssured.given()
		        .contentType(ContentType.JSON)
		        .body("{\"universityID\": \"979\"}")
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .put("/university261")
                .then()
                .statusCode(201);
       
    }
    
    @Test
    public void testIfGetStatusCode401() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .get("/university261")
                .then()
                .statusCode(401);
       
    }
    
    @Test
    public void testIfGetStatusCode404ResponseMissingAuth() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/university261/testing")
                .then()
                .statusCode(404);
       
    }  
	
   

}