package com.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UniversityAPICollectionTest {

    @Test
    public void testIfGetStatusCode200() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/university?universityName=voluptatem")
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
                .get("/university?universityName=voluptatem");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

        // Check if the response body is empty
        assertFalse(responseBody.isEmpty(), "Response body is empty");
    }
    
    @Test
    public void testIfResponse200HasKeyUniversityName() {
    	 // Specify the base URI of your REST API
        RestAssured.baseURI = "http://127.0.0.1:4010";

        // Send a request and get the response
        Response response = RestAssured.given()
        		.header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/university?universityName=voluptatem");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

   
        // jsonPath() is used parse the JSON response and allows you to extract values from it using JSONPath expressions
        boolean isKeyPresent = response.jsonPath().getMap("").containsKey("UniversityName");

       
        // Check if the key is present in the response body
        assertTrue(isKeyPresent, "Key is not present in the response body");
    }
    
    @Test
    public void testIfResponseHas422InvalidRequests() {
    	 // Specify the base URI of your REST API
        RestAssured.baseURI = "http://127.0.0.1:4010";

        // Send a request and get the response
        RestAssured.given()
        		.header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .put("/university")
                .then()
                .statusCode(422);
        

    }
    
    @Test
    public void testIfResponseBodyIsNotEmptyForPut422response() {
        // Specify the base URI of your REST API
        RestAssured.baseURI = "http://127.0.0.1:4010";

        // Send a request and get the response
        Response response = RestAssured.given()
        		.header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .put("/university");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

        // Check if the response body is empty
        assertFalse(responseBody.isEmpty(), "Response body is empty");
    }

    @Test
    public void testIfResponseHasKeyTitleForPUT422response() {
    	 // Specify the base URI of your REST API
        RestAssured.baseURI = "http://127.0.0.1:4010";

        // Send a request and get the response
        Response response = RestAssured.given()
        		.header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .put("/university");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

   
        // jsonPath() is used parse the JSON response and allows you to extract values from it using JSONPath expressions
        boolean isKeyPresent = response.jsonPath().getMap("").containsKey("title");

       
        // Check if the key is present in the response body
        assertTrue(isKeyPresent, "Key is not present in the response body");
    }

    @Test
    public void testIfPostResponseStatusCode201() {
        RestAssured.given()
		        .contentType(ContentType.JSON)
		        .body("{\"universityName\": \"University of Toronto\"}")
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .post("/university")
                .then()
                .statusCode(201);
       
    }
    
    @Test
    public void testIfDeleteStatusCode204() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .delete("/university?universityName=saepe")
                .then()
                .statusCode(204);
       
    }
    
    @Test
    public void testIfGetStatusCode401() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .get("/university")
                .then()
                .statusCode(401);
       
    }

    @Test
    public void testIfGetResponse401HasExpectedValueFortitle() {

    	 // Specify the base URI of your REST API
        RestAssured.baseURI = "http://127.0.0.1:4010";

        // Send a request and get the response
        Response response = RestAssured.given()
                .get("/university");

        // Extract the body of the response
        String responseBody = response.getBody().asString();

   
        // jsonPath() is used parse the JSON response and allows you to extract values from it using JSONPath expressions
        String title="Invalid security scheme used";
        boolean isValuePresent = response.jsonPath().getMap("").containsValue(title);

       
        // Check if the key is present in the response body
        assertTrue(isValuePresent, "Title value is not present in the response body");
    }
    @Test
    public void testIfGetStatusCode404UrlPathError() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/invalidurl")       
                .then()
                .statusCode(404);
            
    }
    @Test
    public void testIfGetStatusCode200Unencodedparameter() {
        RestAssured.given()
                .baseUri("http://127.0.0.1:4010")
                .header("api_key", "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e")
                .get("/university?universityName=voluptatem Univ")       
                .then()
                .statusCode(200);
           
       
    }
 

}