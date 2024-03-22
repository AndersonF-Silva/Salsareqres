package br.com.SalsaTech.Tests;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteUserTest {
    @BeforeClass
    public static void setup() {

        baseURI = "https://reqres.in/";
    }

    @Test
    public void deveDeletarUser() {
        given()
                .log().all()
                .when()
                .delete("https://reqres.in/api/{entidade}/{userID}", "users", "2")
                .then()
                .log().all()
                .statusCode(204)
        ;
    }
}
