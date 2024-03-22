package br.com.SalsaTech.Tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class ListUserByIDNotFoundTest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    public void ValidarUsuarioPorIDQueNaoExiste() {
        given()
        .when()
            .get("/api/users/23")
        .then()
            .statusCode(404);
    }
}
