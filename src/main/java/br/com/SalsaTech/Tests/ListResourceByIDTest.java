package br.com.SalsaTech.Tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;

public class ListResourceByIDTest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void ListarResourcePorID() {
        given()
                .when()
                .get("/api/unknown/2")
                .then()
                .statusCode(200)
                .log().all()
                .rootPath("data")
                .body(".name", containsString("fuchsia rose"))
                .body(".year", is(2001))
                .body(".color", containsString("#C74375"))
                .body(".pantone_value", containsString("17-2031"))
                .body(".id", is(2))
        ;
    }
}
