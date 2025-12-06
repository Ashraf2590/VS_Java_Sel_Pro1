package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredSampleTest {

    @Test
    public void testGetPost() {
        // simple GET request to a public API and basic assertion
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", greaterThan(0));
    }
}

