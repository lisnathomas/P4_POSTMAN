package com.API;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UniversitiesAPICollectionTest {
	
	@Test
	 public void testIfGetStatusCode200() {
	        RestAssured.given()
	                .baseUri("http://127.0.0.1:4010")
	                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
	                .get("/universities")
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
                .get("/universities");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

        // Check if the response body is empty
        assertFalse(responseBody.isEmpty(), "Response body is empty");
    }
    
    @Test
    public void testIfResponse200HasJsonList() {
    	 // Specify the base URI of your REST API
        RestAssured.baseURI = "http://127.0.0.1:4010";

        // Send a request and get the response
        Response response = RestAssured.given()
        		.header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/universities");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

   
        // response.jsonPath().getList("") is used to check if the parsed JSON is an instance of java.util.List, which is indicative of an array.
        boolean isArray = response.jsonPath().getList("") instanceof java.util.List;

       
        // Check if the key is present in the response body
        assertTrue(isArray, "Key is not present in the response body");
    }
    @Test
    public void testIfGetStatusCode404UrlPathError() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/universities/invalidurl")       
                .then()
                .statusCode(404);
            
    }
    @Test
    public void testIfGetStatusCode401() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .get("/universities")
                .then()
                .statusCode(401);
       
    }
   
    @Test
    public void testIfGetStatusCode404ResponseMissingAuth() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/universities?__server=https://zafin-interview.io/api")
                .then()
                .statusCode(404);
       
    }  
	  
}
