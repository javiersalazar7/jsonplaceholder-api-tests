package com.javier.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeAll;

public class JsonPlaceholderApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    void testGetAllPosts() {
        RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .body("size()", equalTo(100));
    }

    @Test
    void testGetSinglePost() {
        RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", notNullValue());
    }

    @Test
    void testMissingPostReturns404()  {
        RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/999")
                .then()
                .statusCode(404);

    }

    @Test
    void testCreatePost() {
        RestAssured
                .given()
                .header("Content-type", "application/json")
                .body("{ \"title\": \"Test Title\", \"body\": \"Test body.\", \"userId\": 1 }")
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Test Title"))
                .body("body", equalTo("Test body."))
                .body("userId", equalTo(1))
                .body("id", notNullValue());  // Fake API returns a new ID
    }


}

