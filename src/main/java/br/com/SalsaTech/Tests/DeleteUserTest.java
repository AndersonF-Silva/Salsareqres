package br.com.SalsaTech.Tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteUserTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
     @Test
    public void deveDeletarUser() {
        given()
                .log().all()
                .when()
                .delete("/api/{entidade}/{userID}", "users", "2")
                .then()
                .log().all()
                .statusCode(204)
        ;
    }
}
