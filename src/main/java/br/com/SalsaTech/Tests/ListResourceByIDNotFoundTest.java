package br.com.SalsaTech.Tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ListResourceByIDNotFoundTest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }
    @Test
    public void ValidarCorPorIDQueNaoExiste() {
        given()
                .when()
                .get("/api/unknown/23")
                .then()
                .statusCode(404);
    }
}
